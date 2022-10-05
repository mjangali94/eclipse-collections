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
import org.eclipse.collections.api.block.function.primitive.ShortToBooleanFunction;
import org.eclipse.collections.api.map.primitive.MutableShortBooleanMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortBooleanHashMap}.
 * This file was automatically generated from template file primitiveBooleanHashMapTest.stg.
 */
public class ShortBooleanHashMapTest extends AbstractMutableShortBooleanMapTestCase {

    @Override
    protected ShortBooleanHashMap classUnderTest() {
        return ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true);
    }

    @Override
    protected ShortBooleanHashMap newWithKeysValues(short key1, boolean value1) {
        return new ShortBooleanHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ShortBooleanHashMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2) {
        return new ShortBooleanHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ShortBooleanHashMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3) {
        return new ShortBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortBooleanHashMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3, short key4, boolean value4) {
        return new ShortBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortBooleanHashMap getEmptyMap() {
        return new ShortBooleanHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception {
        Field keys = ShortBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void newWithInitialCapacity() throws Exception {
        Field keys = ShortBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap(3);
        Assert.assertEquals(8L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        ShortBooleanHashMap hashMap2 = new ShortBooleanHashMap(15);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap2)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws() {
        new ShortBooleanHashMap(-1);
    }

    @Test
    public void newMap() throws Exception {
        Field keys = ShortBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Assert.assertEquals(new ShortBooleanHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception {
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        for (short i = (short) 2; i < 10; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == (short) 0);
        }
        Field keys = ShortBooleanHashMap.class.getDeclaredField("keys");
        Field values = ShortBooleanHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Verify.assertSize(8, hashMap);
        for (short i = (short) 2; i < 10; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertTrue(hashMap.containsValue(false));
        Assert.assertTrue(hashMap.containsValue(true));
        hashMap.put((short) 10, true);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        for (short i = 11; i < 75; i++) {
            Assert.assertFalse(String.valueOf(i), hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == (short) 0);
        }
        Assert.assertEquals(256L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(256L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void testPutAll() {
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        MutableShortBooleanMap copyMap = new ShortBooleanHashMap();
        for (short i = (short) 1; i < 11; i++) {
            Assert.assertFalse(hashMap.containsKey(i));
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, (i & 1) == (short) 0);
        }
        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);
        for (short i = (short) 1; i < 11; i++) {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(copyMap.containsKey(i));
        }
        Assert.assertEquals(hashMap, copyMap);
    }

    @Override
    @Test
    public void withKeysValues() {
        super.withKeysValues();
        ShortBooleanHashMap hashMap0 = new ShortBooleanHashMap();
        Assert.assertSame(hashMap0.withKeysValues((short) 1, false, (short) 2, true), hashMap0);
        ShortBooleanHashMap hashMap1 = new ShortBooleanHashMap().withKeysValues((short) 1, false, (short) 2, true, (short) 3, false);
        ShortBooleanHashMap hashMap2 = new ShortBooleanHashMap().withKeysValues((short) 1, false, (short) 2, true, (short) 3, false, (short) 4, true);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false, (short) 2, true), hashMap0);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false, (short) 2, true, (short) 3, false), hashMap1);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false, (short) 2, true, (short) 3, false, (short) 4, true), hashMap2);
    }

    @Test
    public void injectInto() {
        ShortBooleanHashMap hashMap0 = new ShortBooleanHashMap().withKeysValues((short) 1, false, (short) 2, true, (short) 3, false, (short) 4, false);
        Short total = hashMap0.injectInto(Short.valueOf((short) 0), (Short result, boolean value) -> value ? result : Short.valueOf((short) (result + (short) 2)));
        Assert.assertEquals(Short.valueOf((short) 6), total);
    }

    @Test
    public void put_every_slot() {
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        for (short each = (short) 2; each < (short) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.put(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
            hashMap.remove(each);
            Assert.assertFalse(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot() {
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        for (short each = (short) 2; each < (short) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            hashMap.getIfAbsentPut(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot() {
        BooleanFunction<String> functionLength = String::isEmpty;
        MutableShortBooleanMap hashMap = this.getEmptyMap();
        for (short each = (short) 2; each < (short) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPutWith(each, functionLength, ""));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot() {
        ShortToBooleanFunction function = (short each) -> each % 2 == 0;
        MutableShortBooleanMap hashMap = this.getEmptyMap();
        for (short each = (short) 2; each < (short) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 == 0, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot() {
        BooleanFunction0 factory = () -> true;
        MutableShortBooleanMap hashMap = this.getEmptyMap();
        for (short each = (short) 2; each < (short) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPut(each, factory));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void updateValue_every_slot() {
        BooleanToBooleanFunction function = (boolean value) -> !value;
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        for (short each = (short) 2; each < (short) 100; each++) {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 != 0, hashMap.updateValue(each, each % 2 == 0, function));
            Assert.assertEquals(each % 2 != 0, hashMap.get(each));
        }
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ShortBooleanHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ShortBooleanHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ShortBooleanHashMapTest> updateValue_every_slot;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = ShortBooleanHashMapTest::isEmpty;
            this.payloads.notEmpty = ShortBooleanHashMapTest::notEmpty;
            this.payloads.testEquals = ShortBooleanHashMapTest::testEquals;
            this.payloads.testHashCode = ShortBooleanHashMapTest::testHashCode;
            this.payloads.testToString = ShortBooleanHashMapTest::testToString;
            this.payloads.forEach = ShortBooleanHashMapTest::forEach;
            this.payloads.forEachValue = ShortBooleanHashMapTest::forEachValue;
            this.payloads.forEachKey = ShortBooleanHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ShortBooleanHashMapTest::forEachKeyValue;
            this.payloads.makeString = ShortBooleanHashMapTest::makeString;
            this.payloads.appendString = ShortBooleanHashMapTest::appendString;
            this.payloads.select = ShortBooleanHashMapTest::select;
            this.payloads.reject = ShortBooleanHashMapTest::reject;
            this.payloads.select_value = ShortBooleanHashMapTest::select_value;
            this.payloads.reject_value = ShortBooleanHashMapTest::reject_value;
            this.payloads.collect = ShortBooleanHashMapTest::collect;
            this.payloads.count = ShortBooleanHashMapTest::count;
            this.payloads.detectIfNone_value = ShortBooleanHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ShortBooleanHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ShortBooleanHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ShortBooleanHashMapTest::noneSatisfy;
            this.payloads.toList = ShortBooleanHashMapTest::toList;
            this.payloads.toSet = ShortBooleanHashMapTest::toSet;
            this.payloads.toBag = ShortBooleanHashMapTest::toBag;
            this.payloads.booleanIterator = ShortBooleanHashMapTest::booleanIterator;
            this.payloads.asLazy = ShortBooleanHashMapTest::asLazy;
            this.payloads.keysView = ShortBooleanHashMapTest::keysView;
            this.payloads.keyValuesView = ShortBooleanHashMapTest::keyValuesView;
            this.payloads.toArray = ShortBooleanHashMapTest::toArray;
            this.payloads.toImmutable = ShortBooleanHashMapTest::toImmutable;
            this.payloads.clear = ShortBooleanHashMapTest::clear;
            this.payloads.removeKey = ShortBooleanHashMapTest::removeKey;
            this.payloads.removeKeyIfAbsent = ShortBooleanHashMapTest::removeKeyIfAbsent;
            this.payloads.put = ShortBooleanHashMapTest::put;
            this.payloads.updateValues = ShortBooleanHashMapTest::updateValues;
            this.payloads.putDuplicateWithRemovedSlot = ShortBooleanHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = ShortBooleanHashMapTest::get;
            this.payloads.getIfAbsent = ShortBooleanHashMapTest::getIfAbsent;
            this.payloads.getOrThrow = ShortBooleanHashMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = ShortBooleanHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = ShortBooleanHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = ShortBooleanHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = ShortBooleanHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = ShortBooleanHashMapTest::updateValue;
            this.payloads.containsKey = ShortBooleanHashMapTest::containsKey;
            this.payloads.containsValue = ShortBooleanHashMapTest::containsValue;
            this.payloads.contains = ShortBooleanHashMapTest::contains;
            this.payloads.containsAll = ShortBooleanHashMapTest::containsAll;
            this.payloads.containsAllIterable = ShortBooleanHashMapTest::containsAllIterable;
            this.payloads.size = ShortBooleanHashMapTest::size;
            this.payloads.withoutKey = ShortBooleanHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = ShortBooleanHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = ShortBooleanHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = ShortBooleanHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = ShortBooleanHashMapTest::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = ShortBooleanHashMapTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = ShortBooleanHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = ShortBooleanHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.defaultInitialCapacity = ShortBooleanHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = ShortBooleanHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ShortBooleanHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = ShortBooleanHashMapTest::newMap;
            this.payloads.putWithRehash = ShortBooleanHashMapTest::putWithRehash;
            this.payloads.testPutAll = ShortBooleanHashMapTest::testPutAll;
            this.payloads.withKeysValues = ShortBooleanHashMapTest::withKeysValues;
            this.payloads.injectInto = ShortBooleanHashMapTest::injectInto;
            this.payloads.put_every_slot = ShortBooleanHashMapTest::put_every_slot;
            this.payloads.getIfAbsentPut_every_slot = ShortBooleanHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = ShortBooleanHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = ShortBooleanHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = ShortBooleanHashMapTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = ShortBooleanHashMapTest::updateValue_every_slot;
        }
    }
}
