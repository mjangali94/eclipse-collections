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
import org.eclipse.collections.api.block.function.primitive.IntToBooleanFunction;
import org.eclipse.collections.api.map.primitive.MutableIntBooleanMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntBooleanHashMap}.
 * This file was automatically generated from template file primitiveBooleanHashMapTest.stg.
 */
public class IntBooleanHashMapTest extends AbstractMutableIntBooleanMapTestCase {

    @Override
    protected IntBooleanHashMap classUnderTest() {
        return IntBooleanHashMap.newWithKeysValues(0, true, 31, false, 32, true);
    }

    @Override
    protected IntBooleanHashMap newWithKeysValues(int key1, boolean value1) {
        return new IntBooleanHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected IntBooleanHashMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2) {
        return new IntBooleanHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected IntBooleanHashMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3) {
        return new IntBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected IntBooleanHashMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3, int key4, boolean value4) {
        return new IntBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected IntBooleanHashMap getEmptyMap() {
        return new IntBooleanHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = IntBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        IntBooleanHashMap hashMap = new IntBooleanHashMap();
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = IntBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        IntBooleanHashMap hashMap = new IntBooleanHashMap(3);
        Assert.assertEquals(8L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        IntBooleanHashMap hashMap2 = new IntBooleanHashMap(15);
        Assert.assertEquals(32L, ((int[]) keys.get(hashMap2)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new IntBooleanHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = IntBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        IntBooleanHashMap hashMap = new IntBooleanHashMap();
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Assert.assertEquals(new IntBooleanHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        IntBooleanHashMap hashMap = new IntBooleanHashMap();
        for (int i = 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == 0);
        }
        Field keys = IntBooleanHashMap.class.getDeclaredField("keys");
        Field values = IntBooleanHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertTrue(hashMap.containsValue(false));
        Assert.assertTrue(hashMap.containsValue(true));
        hashMap.put(10, true);
        Assert.assertEquals(32L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        for (int i = 11; i < 75; i++) {
            Assert.assertFalse(String.valueOf(i), hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == 0);
        }
        Assert.assertEquals(256L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(256L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void testPutAll() {
        IntBooleanHashMap hashMap = new IntBooleanHashMap();
        MutableIntBooleanMap copyMap = new IntBooleanHashMap();
        for (int i = 1; i < 11; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, (i & 1) == 0);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (int i = 1; i < 11; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(copyMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        IntBooleanHashMap hashMap0 = new IntBooleanHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1, false, 2, true), hashMap0);
        IntBooleanHashMap hashMap1 = new IntBooleanHashMap().withKeysValues(1, false, 2, true, 3, false);
        IntBooleanHashMap hashMap2 = new IntBooleanHashMap().withKeysValues(1, false, 2, true, 3, false, 4, true);
        Assert.assertEquals(IntBooleanHashMap.newWithKeysValues(1, false, 2, true), hashMap0);
        Assert.assertEquals(IntBooleanHashMap.newWithKeysValues(1, false, 2, true, 3, false), hashMap1);
        Assert.assertEquals(IntBooleanHashMap.newWithKeysValues(1, false, 2, true, 3, false, 4, true), hashMap2);
    }

    @Test
    public void injectInto() {
        IntBooleanHashMap hashMap0 = new IntBooleanHashMap().withKeysValues(1, false, 2, true, 3, false, 4, false);
        Integer total = hashMap0.injectInto(Integer.valueOf(0), (Integer result, boolean value) -> value ? result : Integer.valueOf((int) (result + 2)));
        Assert.assertEquals(Integer.valueOf(6), total);
    }

    @Test
    public void put_every_slot() {
        IntBooleanHashMap hashMap = new IntBooleanHashMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.put(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
            hashMap.remove(each);
            Assert.assertFalse(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        IntBooleanHashMap hashMap = new IntBooleanHashMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.getIfAbsentPut(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        BooleanFunction<String> functionLength = String::isEmpty;
        MutableIntBooleanMap hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPutWith(each, functionLength, ""));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        IntToBooleanFunction function = (int each) -> each % 2 == 0;
        MutableIntBooleanMap hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 == 0, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        BooleanFunction0 factory = () -> true;
        MutableIntBooleanMap hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPut(each, factory));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void updateValue_every_slot() {
        BooleanToBooleanFunction function = (boolean value) -> !value;
        IntBooleanHashMap hashMap = new IntBooleanHashMap();
        for (int each = 2; each < 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 != 0, hashMap.updateValue(each, each % 2 == 0, function));
            Assert.assertEquals(each % 2 != 0, hashMap.get(each));
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private IntBooleanHashMapTest instance;

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
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_booleanIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
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
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
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
        public void benchmark_putDuplicateWithRemovedSlot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putDuplicateWithRemovedSlot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
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
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_booleanIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.booleanIterator_with_remove);
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
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new IntBooleanHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<IntBooleanHashMapTest> updateValue_every_slot;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = IntBooleanHashMapTest::isEmpty;
            this.payloads.notEmpty = IntBooleanHashMapTest::notEmpty;
            this.payloads.testEquals = IntBooleanHashMapTest::testEquals;
            this.payloads.testHashCode = IntBooleanHashMapTest::testHashCode;
            this.payloads.testToString = IntBooleanHashMapTest::testToString;
            this.payloads.forEach = IntBooleanHashMapTest::forEach;
            this.payloads.forEachValue = IntBooleanHashMapTest::forEachValue;
            this.payloads.forEachKey = IntBooleanHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = IntBooleanHashMapTest::forEachKeyValue;
            this.payloads.makeString = IntBooleanHashMapTest::makeString;
            this.payloads.appendString = IntBooleanHashMapTest::appendString;
            this.payloads.select = IntBooleanHashMapTest::select;
            this.payloads.reject = IntBooleanHashMapTest::reject;
            this.payloads.select_value = IntBooleanHashMapTest::select_value;
            this.payloads.reject_value = IntBooleanHashMapTest::reject_value;
            this.payloads.collect = IntBooleanHashMapTest::collect;
            this.payloads.count = IntBooleanHashMapTest::count;
            this.payloads.detectIfNone_value = IntBooleanHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = IntBooleanHashMapTest::anySatisfy;
            this.payloads.allSatisfy = IntBooleanHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = IntBooleanHashMapTest::noneSatisfy;
            this.payloads.toList = IntBooleanHashMapTest::toList;
            this.payloads.toSet = IntBooleanHashMapTest::toSet;
            this.payloads.toBag = IntBooleanHashMapTest::toBag;
            this.payloads.booleanIterator = IntBooleanHashMapTest::booleanIterator;
            this.payloads.asLazy = IntBooleanHashMapTest::asLazy;
            this.payloads.keysView = IntBooleanHashMapTest::keysView;
            this.payloads.keyValuesView = IntBooleanHashMapTest::keyValuesView;
            this.payloads.toArray = IntBooleanHashMapTest::toArray;
            this.payloads.toImmutable = IntBooleanHashMapTest::toImmutable;
            this.payloads.clear = IntBooleanHashMapTest::clear;
            this.payloads.removeKey = IntBooleanHashMapTest::removeKey;
            this.payloads.removeKeyIfAbsent = IntBooleanHashMapTest::removeKeyIfAbsent;
            this.payloads.put = IntBooleanHashMapTest::put;
            this.payloads.updateValues = IntBooleanHashMapTest::updateValues;
            this.payloads.putDuplicateWithRemovedSlot = IntBooleanHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = IntBooleanHashMapTest::get;
            this.payloads.getIfAbsent = IntBooleanHashMapTest::getIfAbsent;
            this.payloads.getOrThrow = IntBooleanHashMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = IntBooleanHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = IntBooleanHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = IntBooleanHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = IntBooleanHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = IntBooleanHashMapTest::updateValue;
            this.payloads.containsKey = IntBooleanHashMapTest::containsKey;
            this.payloads.containsValue = IntBooleanHashMapTest::containsValue;
            this.payloads.contains = IntBooleanHashMapTest::contains;
            this.payloads.containsAll = IntBooleanHashMapTest::containsAll;
            this.payloads.containsAllIterable = IntBooleanHashMapTest::containsAllIterable;
            this.payloads.size = IntBooleanHashMapTest::size;
            this.payloads.withoutKey = IntBooleanHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = IntBooleanHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = IntBooleanHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = IntBooleanHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = IntBooleanHashMapTest::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = IntBooleanHashMapTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = IntBooleanHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = IntBooleanHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.defaultInitialCapacity = IntBooleanHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = IntBooleanHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(IntBooleanHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = IntBooleanHashMapTest::newMap;
            this.payloads.putWithRehash = IntBooleanHashMapTest::putWithRehash;
            this.payloads.testPutAll = IntBooleanHashMapTest::testPutAll;
            this.payloads.withKeysValues = IntBooleanHashMapTest::withKeysValues;
            this.payloads.injectInto = IntBooleanHashMapTest::injectInto;
            this.payloads.put_every_slot = IntBooleanHashMapTest::put_every_slot;
            this.payloads.getIfAbsentPut_every_slot = IntBooleanHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = IntBooleanHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = IntBooleanHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = IntBooleanHashMapTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = IntBooleanHashMapTest::updateValue_every_slot;
        }
    }
}
