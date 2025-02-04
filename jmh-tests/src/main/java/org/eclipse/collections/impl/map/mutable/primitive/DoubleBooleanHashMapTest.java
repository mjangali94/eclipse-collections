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
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubleBooleanHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new DoubleBooleanHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> booleanIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> booleanIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> defaultInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> newWithInitialCapacity;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> newWithInitialCapacity_negative_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> newMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> putWithRehash;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> testPutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> getIfAbsentPut_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> getIfAbsentPutWith_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> getIfAbsentPutWithKey_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> getIfAbsentPut_Function_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubleBooleanHashMapTest> updateValue_every_slot;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.isEmpty = DoubleBooleanHashMapTest::isEmpty;
            this.payloads.notEmpty = DoubleBooleanHashMapTest::notEmpty;
            this.payloads.testEquals = DoubleBooleanHashMapTest::testEquals;
            this.payloads.testHashCode = DoubleBooleanHashMapTest::testHashCode;
            this.payloads.testToString = DoubleBooleanHashMapTest::testToString;
            this.payloads.forEach = DoubleBooleanHashMapTest::forEach;
            this.payloads.forEachValue = DoubleBooleanHashMapTest::forEachValue;
            this.payloads.forEachKey = DoubleBooleanHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = DoubleBooleanHashMapTest::forEachKeyValue;
            this.payloads.makeString = DoubleBooleanHashMapTest::makeString;
            this.payloads.appendString = DoubleBooleanHashMapTest::appendString;
            this.payloads.select = DoubleBooleanHashMapTest::select;
            this.payloads.reject = DoubleBooleanHashMapTest::reject;
            this.payloads.select_value = DoubleBooleanHashMapTest::select_value;
            this.payloads.reject_value = DoubleBooleanHashMapTest::reject_value;
            this.payloads.collect = DoubleBooleanHashMapTest::collect;
            this.payloads.count = DoubleBooleanHashMapTest::count;
            this.payloads.detectIfNone_value = DoubleBooleanHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = DoubleBooleanHashMapTest::anySatisfy;
            this.payloads.allSatisfy = DoubleBooleanHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = DoubleBooleanHashMapTest::noneSatisfy;
            this.payloads.toList = DoubleBooleanHashMapTest::toList;
            this.payloads.toSet = DoubleBooleanHashMapTest::toSet;
            this.payloads.toBag = DoubleBooleanHashMapTest::toBag;
            this.payloads.booleanIterator = DoubleBooleanHashMapTest::booleanIterator;
            this.payloads.asLazy = DoubleBooleanHashMapTest::asLazy;
            this.payloads.keysView = DoubleBooleanHashMapTest::keysView;
            this.payloads.keyValuesView = DoubleBooleanHashMapTest::keyValuesView;
            this.payloads.toArray = DoubleBooleanHashMapTest::toArray;
            this.payloads.toImmutable = DoubleBooleanHashMapTest::toImmutable;
            this.payloads.clear = DoubleBooleanHashMapTest::clear;
            this.payloads.removeKey = DoubleBooleanHashMapTest::removeKey;
            this.payloads.removeKeyIfAbsent = DoubleBooleanHashMapTest::removeKeyIfAbsent;
            this.payloads.put = DoubleBooleanHashMapTest::put;
            this.payloads.updateValues = DoubleBooleanHashMapTest::updateValues;
            this.payloads.putDuplicateWithRemovedSlot = DoubleBooleanHashMapTest::putDuplicateWithRemovedSlot;
            this.payloads.get = DoubleBooleanHashMapTest::get;
            this.payloads.getIfAbsent = DoubleBooleanHashMapTest::getIfAbsent;
            this.payloads.getOrThrow = DoubleBooleanHashMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = DoubleBooleanHashMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPut_Function = DoubleBooleanHashMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPutWith = DoubleBooleanHashMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithKey = DoubleBooleanHashMapTest::getIfAbsentPutWithKey;
            this.payloads.updateValue = DoubleBooleanHashMapTest::updateValue;
            this.payloads.containsKey = DoubleBooleanHashMapTest::containsKey;
            this.payloads.containsValue = DoubleBooleanHashMapTest::containsValue;
            this.payloads.contains = DoubleBooleanHashMapTest::contains;
            this.payloads.containsAll = DoubleBooleanHashMapTest::containsAll;
            this.payloads.containsAllIterable = DoubleBooleanHashMapTest::containsAllIterable;
            this.payloads.size = DoubleBooleanHashMapTest::size;
            this.payloads.withoutKey = DoubleBooleanHashMapTest::withoutKey;
            this.payloads.withoutAllKeys = DoubleBooleanHashMapTest::withoutAllKeys;
            this.payloads.withAllKeyValues = DoubleBooleanHashMapTest::withAllKeyValues;
            this.payloads.asSynchronized = DoubleBooleanHashMapTest::asSynchronized;
            this.payloads.asUnmodifiable = DoubleBooleanHashMapTest::asUnmodifiable;
            this.payloads.booleanIterator_with_remove = DoubleBooleanHashMapTest::booleanIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = DoubleBooleanHashMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = DoubleBooleanHashMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.defaultInitialCapacity = DoubleBooleanHashMapTest::defaultInitialCapacity;
            this.payloads.newWithInitialCapacity = DoubleBooleanHashMapTest::newWithInitialCapacity;
            this.payloads.newWithInitialCapacity_negative_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubleBooleanHashMapTest::newWithInitialCapacity_negative_throws, java.lang.IllegalArgumentException.class);
            this.payloads.newMap = DoubleBooleanHashMapTest::newMap;
            this.payloads.putWithRehash = DoubleBooleanHashMapTest::putWithRehash;
            this.payloads.testPutAll = DoubleBooleanHashMapTest::testPutAll;
            this.payloads.withKeysValues = DoubleBooleanHashMapTest::withKeysValues;
            this.payloads.injectInto = DoubleBooleanHashMapTest::injectInto;
            this.payloads.put_every_slot = DoubleBooleanHashMapTest::put_every_slot;
            this.payloads.getIfAbsentPut_every_slot = DoubleBooleanHashMapTest::getIfAbsentPut_every_slot;
            this.payloads.getIfAbsentPutWith_every_slot = DoubleBooleanHashMapTest::getIfAbsentPutWith_every_slot;
            this.payloads.getIfAbsentPutWithKey_every_slot = DoubleBooleanHashMapTest::getIfAbsentPutWithKey_every_slot;
            this.payloads.getIfAbsentPut_Function_every_slot = DoubleBooleanHashMapTest::getIfAbsentPut_Function_every_slot;
            this.payloads.updateValue_every_slot = DoubleBooleanHashMapTest::updateValue_every_slot;
        }
    }
}
