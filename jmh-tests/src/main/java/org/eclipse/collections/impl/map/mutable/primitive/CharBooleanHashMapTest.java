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
import org.eclipse.collections.api.block.function.primitive.CharToBooleanFunction;
import org.eclipse.collections.api.map.primitive.MutableCharBooleanMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharBooleanHashMap}.
 * This file was automatically generated from template file primitiveBooleanHashMapTest.stg.
 */
public class CharBooleanHashMapTest extends AbstractMutableCharBooleanMapTestCase {

    @Override
    protected CharBooleanHashMap classUnderTest() {
        return CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, true);
    }

    @Override
    protected CharBooleanHashMap newWithKeysValues(char key1, boolean value1) {
        return new CharBooleanHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected CharBooleanHashMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2) {
        return new CharBooleanHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected CharBooleanHashMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3) {
        return new CharBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected CharBooleanHashMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3, char key4, boolean value4) {
        return new CharBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected CharBooleanHashMap getEmptyMap() {
        return new CharBooleanHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = CharBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = CharBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharBooleanHashMap hashMap = new CharBooleanHashMap(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        CharBooleanHashMap hashMap2 = new CharBooleanHashMap(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new CharBooleanHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = CharBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Assert.assertEquals(new CharBooleanHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        for (char i = (char) 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == (char) 0);
        }
        Field keys = CharBooleanHashMap.class.getDeclaredField("keys");
        Field values = CharBooleanHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Verify.assertSize(8, hashMap);
        for (char i = (char) 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertTrue(hashMap.containsValue(false));
        Assert.assertTrue(hashMap.containsValue(true));
        hashMap.put((char) 10, true);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        for (char i = 11; i < 75; i++) {
            Assert.assertFalse(String.valueOf(i), hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == (char) 0);
        }
        Assert.assertEquals(256L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(256L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void testPutAll() {
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        MutableCharBooleanMap copyMap = new CharBooleanHashMap();
        for (char i = (char) 1; i < 11; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, (i & 1) == (char) 0);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (char i = (char) 1; i < 11; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(copyMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        CharBooleanHashMap hashMap0 = new CharBooleanHashMap();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, false, (char) 2, true), hashMap0);
        CharBooleanHashMap hashMap1 = new CharBooleanHashMap().withKeysValues((char) 1, false, (char) 2, true, (char) 3, false);
        CharBooleanHashMap hashMap2 = new CharBooleanHashMap().withKeysValues((char) 1, false, (char) 2, true, (char) 3, false, (char) 4, true);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false, (char) 2, true), hashMap0);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false, (char) 2, true, (char) 3, false), hashMap1);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false, (char) 2, true, (char) 3, false, (char) 4, true), hashMap2);
    }

    @Test
    public void injectInto() {
        CharBooleanHashMap hashMap0 = new CharBooleanHashMap().withKeysValues((char) 1, false, (char) 2, true, (char) 3, false, (char) 4, false);
        Character total = hashMap0.injectInto(Character.valueOf((char) 0), (Character result, boolean value) -> value ? result : Character.valueOf((char) (result + (char) 2)));
        Assert.assertEquals(Character.valueOf((char) 6), total);
    }

    @Test
    public void put_every_slot() {
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.put(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
            hashMap.remove(each);
            Assert.assertFalse(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.getIfAbsentPut(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        BooleanFunction<String> functionLength = String::isEmpty;
        MutableCharBooleanMap hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPutWith(each, functionLength, ""));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        CharToBooleanFunction function = (char each) -> each % 2 == 0;
        MutableCharBooleanMap hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 == 0, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        BooleanFunction0 factory = () -> true;
        MutableCharBooleanMap hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPut(each, factory));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void updateValue_every_slot() {
        BooleanToBooleanFunction function = (boolean value) -> !value;
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        for (char each = (char) 2; each < (char) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 != 0, hashMap.updateValue(each, each % 2 == 0, function));
            Assert.assertEquals(each % 2 != 0, hashMap.get(each));
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private CharBooleanHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new CharBooleanHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<CharBooleanHashMapTest> updateValue_every_slot;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = CharBooleanHashMapTest::isEmpty;
            this.payloads.notEmpty = CharBooleanHashMapTest::notEmpty;
            this.payloads.testEquals = CharBooleanHashMapTest::testEquals;
            this.payloads.testHashCode = CharBooleanHashMapTest::testHashCode;
            this.payloads.testToString = CharBooleanHashMapTest::testToString;
            this.payloads.forEach = CharBooleanHashMapTest::forEach;
            this.payloads.forEachValue = CharBooleanHashMapTest::forEachValue;
            this.payloads.forEachKey = CharBooleanHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = CharBooleanHashMapTest::forEachKeyValue;
            this.payloads.makeString = CharBooleanHashMapTest::makeString;
            this.payloads.appendString = CharBooleanHashMapTest::appendString;
            this.payloads.select = CharBooleanHashMapTest::select;
            this.payloads.reject = CharBooleanHashMapTest::reject;
            this.payloads.select_value = CharBooleanHashMapTest::select_value;
            this.payloads.reject_value = CharBooleanHashMapTest::reject_value;
            this.payloads.collect = CharBooleanHashMapTest::collect;
            this.payloads.count = CharBooleanHashMapTest::count;
            this.payloads.detectIfNone_value = CharBooleanHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = CharBooleanHashMapTest::anySatisfy;
            this.payloads.allSatisfy = CharBooleanHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = CharBooleanHashMapTest::noneSatisfy;
            this.payloads.toList = CharBooleanHashMapTest::toList;
            this.payloads.toSet = CharBooleanHashMapTest::toSet;
            this.payloads.toBag = CharBooleanHashMapTest::toBag;
            this.payloads.booleanIterator = CharBooleanHashMapTest::booleanIterator;
            this.payloads.asLazy = CharBooleanHashMapTest::asLazy;
            this.payloads.keysView = CharBooleanHashMapTest::keysView;
            this.payloads.keyValuesView = CharBooleanHashMapTest::keyValuesView;
            this.payloads.toArray = CharBooleanHashMapTest::toArray;
            this.payloads.toImmutable = CharBooleanHashMapTest::toImmutable;
            this.payloads.clear = CharBooleanHashMapTest::clear;
            this.payloads.removeKey = CharBooleanHashMapTest::removeKey;
            this.payloads.removeKeyIfAbsent = CharBooleanHashMapTest::removeKeyIfAbsent;
            this.payloads.put = CharBooleanHashMapTest::put;
            this.payloads.updateValues = CharBooleanHashMapTest::updateValues;
            this.payloads.putDuplicateWithRemovedSlot = CharBooleanHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = CharBooleanHashMapTest::get;
            this.payloads.getIfAbsent = CharBooleanHashMapTest::getIfAbsent;
            this.payloads.getOrThrow = CharBooleanHashMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = CharBooleanHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = CharBooleanHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = CharBooleanHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = CharBooleanHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = CharBooleanHashMapTest::updateValue;
            this.payloads.containsKey = CharBooleanHashMapTest::containsKey;
            this.payloads.containsValue = CharBooleanHashMapTest::containsValue;
            this.payloads.contains = CharBooleanHashMapTest::contains;
            this.payloads.containsAll = CharBooleanHashMapTest::containsAll;
            this.payloads.containsAllIterable = CharBooleanHashMapTest::containsAllIterable;
            this.payloads.size = CharBooleanHashMapTest::size;
            this.payloads.withoutKey = CharBooleanHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = CharBooleanHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = CharBooleanHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = CharBooleanHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = CharBooleanHashMapTest::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = CharBooleanHashMapTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = CharBooleanHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = CharBooleanHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.defaultInitialCapacity = CharBooleanHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = CharBooleanHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(CharBooleanHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = CharBooleanHashMapTest::newMap;
            this.payloads.putWithRehash = CharBooleanHashMapTest::putWithRehash;
            this.payloads.testPutAll = CharBooleanHashMapTest::testPutAll;
            this.payloads.withKeysValues = CharBooleanHashMapTest::withKeysValues;
            this.payloads.injectInto = CharBooleanHashMapTest::injectInto;
            this.payloads.put_every_slot = CharBooleanHashMapTest::put_every_slot;
            this.payloads.getIfAbsentPut_every_slot = CharBooleanHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = CharBooleanHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = CharBooleanHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = CharBooleanHashMapTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = CharBooleanHashMapTest::updateValue_every_slot;
        }
    }
}
