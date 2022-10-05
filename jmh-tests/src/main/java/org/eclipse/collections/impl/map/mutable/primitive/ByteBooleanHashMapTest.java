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
    public static class _Benchmark {

        private _Payloads payloads;

        private ByteBooleanHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ByteBooleanHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ByteBooleanHashMapTest> updateValue_every_slot;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = ByteBooleanHashMapTest::isEmpty;
            this.payloads.notEmpty = ByteBooleanHashMapTest::notEmpty;
            this.payloads.testEquals = ByteBooleanHashMapTest::testEquals;
            this.payloads.testHashCode = ByteBooleanHashMapTest::testHashCode;
            this.payloads.testToString = ByteBooleanHashMapTest::testToString;
            this.payloads.forEach = ByteBooleanHashMapTest::forEach;
            this.payloads.forEachValue = ByteBooleanHashMapTest::forEachValue;
            this.payloads.forEachKey = ByteBooleanHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ByteBooleanHashMapTest::forEachKeyValue;
            this.payloads.makeString = ByteBooleanHashMapTest::makeString;
            this.payloads.appendString = ByteBooleanHashMapTest::appendString;
            this.payloads.select = ByteBooleanHashMapTest::select;
            this.payloads.reject = ByteBooleanHashMapTest::reject;
            this.payloads.select_value = ByteBooleanHashMapTest::select_value;
            this.payloads.reject_value = ByteBooleanHashMapTest::reject_value;
            this.payloads.collect = ByteBooleanHashMapTest::collect;
            this.payloads.count = ByteBooleanHashMapTest::count;
            this.payloads.detectIfNone_value = ByteBooleanHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ByteBooleanHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ByteBooleanHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ByteBooleanHashMapTest::noneSatisfy;
            this.payloads.toList = ByteBooleanHashMapTest::toList;
            this.payloads.toSet = ByteBooleanHashMapTest::toSet;
            this.payloads.toBag = ByteBooleanHashMapTest::toBag;
            this.payloads.booleanIterator = ByteBooleanHashMapTest::booleanIterator;
            this.payloads.asLazy = ByteBooleanHashMapTest::asLazy;
            this.payloads.keysView = ByteBooleanHashMapTest::keysView;
            this.payloads.keyValuesView = ByteBooleanHashMapTest::keyValuesView;
            this.payloads.toArray = ByteBooleanHashMapTest::toArray;
            this.payloads.toImmutable = ByteBooleanHashMapTest::toImmutable;
            this.payloads.clear = ByteBooleanHashMapTest::clear;
            this.payloads.removeKey = ByteBooleanHashMapTest::removeKey;
            this.payloads.removeKeyIfAbsent = ByteBooleanHashMapTest::removeKeyIfAbsent;
            this.payloads.put = ByteBooleanHashMapTest::put;
            this.payloads.updateValues = ByteBooleanHashMapTest::updateValues;
            this.payloads.putDuplicateWithRemovedSlot = ByteBooleanHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = ByteBooleanHashMapTest::get;
            this.payloads.getIfAbsent = ByteBooleanHashMapTest::getIfAbsent;
            this.payloads.getOrThrow = ByteBooleanHashMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = ByteBooleanHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = ByteBooleanHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ByteBooleanHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ByteBooleanHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ByteBooleanHashMapTest::updateValue;
            this.payloads.containsKey = ByteBooleanHashMapTest::containsKey;
            this.payloads.containsValue = ByteBooleanHashMapTest::containsValue;
            this.payloads.contains = ByteBooleanHashMapTest::contains;
            this.payloads.containsAll = ByteBooleanHashMapTest::containsAll;
            this.payloads.containsAllIterable = ByteBooleanHashMapTest::containsAllIterable;
            this.payloads.size = ByteBooleanHashMapTest::size;
            this.payloads.withoutKey = ByteBooleanHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ByteBooleanHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ByteBooleanHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = ByteBooleanHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = ByteBooleanHashMapTest::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = ByteBooleanHashMapTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = ByteBooleanHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = ByteBooleanHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.defaultInitialCapacity = ByteBooleanHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ByteBooleanHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ByteBooleanHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ByteBooleanHashMapTest::newMap;
            this.payloads.putWithRehash = ByteBooleanHashMapTest::putWithRehash;
            this.payloads.testPutAll = ByteBooleanHashMapTest::testPutAll;
            this.payloads.withKeysValues = ByteBooleanHashMapTest::withKeysValues;
            this.payloads.injectInto = ByteBooleanHashMapTest::injectInto;
            this.payloads.put_every_slot = ByteBooleanHashMapTest::put_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ByteBooleanHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ByteBooleanHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ByteBooleanHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ByteBooleanHashMapTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ByteBooleanHashMapTest::updateValue_every_slot;
        }
    }
}
