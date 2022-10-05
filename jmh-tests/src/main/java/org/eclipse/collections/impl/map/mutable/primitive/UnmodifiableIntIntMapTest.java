/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.api.map.primitive.MutableIntIntMap;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableIntIntMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableIntIntMapTest extends AbstractMutableIntIntMapTestCase {

    private final UnmodifiableIntIntMap map = this.classUnderTest();

    @Override
    protected UnmodifiableIntIntMap classUnderTest() {
        return new UnmodifiableIntIntMap(IntIntHashMap.newWithKeysValues(0, 0, 31, 31, 32, 32));
    }

    @Override
    protected UnmodifiableIntIntMap newWithKeysValues(int key1, int value1) {
        return new UnmodifiableIntIntMap(new IntIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2) {
        return new UnmodifiableIntIntMap(new IntIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3) {
        return new UnmodifiableIntIntMap(new IntIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableIntIntMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3, int key4, int value4) {
        return new UnmodifiableIntIntMap(new IntIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableIntIntMap getEmptyMap() {
        return new UnmodifiableIntIntMap(new IntIntHashMap());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.map.clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeKey() {
        this.map.removeKey(5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.map.remove(5);
    }

    @Override
    @Test
    public void removeKeyIfAbsent() {
        Assert.assertEquals(100, this.map.removeKeyIfAbsent(10, 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException() {
        Assert.assertEquals(100, this.map.removeKeyIfAbsent(10, 100));
        this.map.removeKeyIfAbsent(0, 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put() {
        this.map.put(0, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getAndPut() {
        this.map.getAndPut(0, 1, 2);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair(0, 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValues() {
        this.map.updateValues((k, v) -> v);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue() {
        this.map.addToValue(0, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues() {
        this.map.withKeyValue(1, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey() {
        this.map.withoutKey(32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys() {
        this.map.withoutAllKeys(IntArrayList.newListWith(0, 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAllKeyValues() {
        this.map.withAllKeyValues(Iterables.iList(PrimitiveTuples.pair(1, 1)));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot() {
        int collision1 = AbstractMutableIntIntMapTestCase.generateCollisions().getFirst();
        UnmodifiableIntIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get(0));
        Assert.assertEquals(31L, this.map.get(31));
        Assert.assertEquals(32L, this.map.get(32));
        Assert.assertEquals(0L, this.map.get(1));
        Assert.assertEquals(0L, this.map.get(33));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent(0, 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31, 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32, 5));
        Assert.assertEquals(6L, this.map.getIfAbsent(33, 6));
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow(0));
        Assert.assertEquals(31L, this.map.getOrThrow(31));
        Assert.assertEquals(32L, this.map.getOrThrow(32));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33));
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0, 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException() {
        this.map.getIfAbsentPut(10, 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function() {
        IntFunction0 factory = () -> 100;
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException() {
        IntFunction0 factory = () -> 100;
        this.map.getIfAbsentPut(10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        IntFunction<String> functionLength = (String string) -> string.length();
        Assert.assertEquals(0L, this.map.getIfAbsentPutWith(0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException() {
        IntFunction<String> functionLength = (String string) -> string.length();
        this.map.getIfAbsentPutWith(10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey() {
        IntToIntFunction function = (int intParameter) -> intParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey(0, function));
    }

    @Override
    @Test
    public void freeze() {
        MutableIntIntMap mutableIntIntMap = this.classUnderTest();
        IntSet frozenSet = mutableIntIntMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException() {
        IntToIntFunction function = (int intParameter) -> intParameter;
        this.map.getIfAbsentPutWithKey(10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException() {
        UnmodifiableIntIntMap copyMap = new UnmodifiableIntIntMap(IntIntHashMap.newWithKeysValues(0, 0, 31, 31, 32, 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        this.map.updateValue(0, 0, incrementFunction);
    }

    @Override
    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0));
        Assert.assertTrue(this.map.contains(31));
        Assert.assertTrue(this.map.contains(32));
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey(0));
        Assert.assertTrue(this.map.containsKey(31));
        Assert.assertTrue(this.map.containsKey(32));
        Assert.assertFalse(this.map.containsKey(1));
        Assert.assertFalse(this.map.containsKey(5));
        Assert.assertFalse(this.map.containsKey(35));
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertTrue(this.map.containsValue(0));
        Assert.assertTrue(this.map.containsValue(31));
        Assert.assertTrue(this.map.containsValue(32));
    }

    @Override
    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0, 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1, 1).size());
        Assert.assertEquals(2, this.newWithKeysValues(1, 1, 5, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0, 0, 5, 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1, 1, 0, 0, 5, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6, 6, 5, 5).size());
        Verify.assertSize(3, this.map);
    }

    @Override
    @Test
    public void asUnmodifiable() {
        super.asUnmodifiable();
        Assert.assertSame(this.map, this.map.asUnmodifiable());
    }

    @Override
    @Test
    public void intIterator_with_remove() {
        MutableIntIterator iterator = this.map.intIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next() {
        MutableIntIterator iterator = this.map.intIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove() {
        // Not applicable for Unmodifiable*
    }

    @Override
    @Test
    public void flipUniqueValues() {
        super.flipUniqueValues();
        Verify.assertInstanceOf(UnmodifiableIntIntMap.class, this.classUnderTest().flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableIntIntMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

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
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialize);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializeKeySet);
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
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsentThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsentThrowsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
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
        public void benchmark_getIfAbsentPutThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutThrowsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_FunctionThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_FunctionThrowsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithThrowsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKeyThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKeyThrowsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllThrowsException);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator_with_remove);
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
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableIntIntMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> removeKeyIfAbsentThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> getIfAbsentPutThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> getIfAbsentPut_FunctionThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> getIfAbsentPutWithThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> getIfAbsentPutWithKeyThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> putAllThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableIntIntMapTest> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = UnmodifiableIntIntMapTest::keySet;
            this.payloads.values = UnmodifiableIntIntMapTest::values;
            this.payloads.containsAll = UnmodifiableIntIntMapTest::containsAll;
            this.payloads.containsAll_Iterable = UnmodifiableIntIntMapTest::containsAll_Iterable;
            this.payloads.isEmpty = UnmodifiableIntIntMapTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableIntIntMapTest::notEmpty;
            this.payloads.testEquals = UnmodifiableIntIntMapTest::testEquals;
            this.payloads.testHashCode = UnmodifiableIntIntMapTest::testHashCode;
            this.payloads.testToString = UnmodifiableIntIntMapTest::testToString;
            this.payloads.forEach = UnmodifiableIntIntMapTest::forEach;
            this.payloads.forEachValue = UnmodifiableIntIntMapTest::forEachValue;
            this.payloads.forEachKey = UnmodifiableIntIntMapTest::forEachKey;
            this.payloads.forEachKeyValue = UnmodifiableIntIntMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnmodifiableIntIntMapTest::injectIntoKeyValue;
            this.payloads.makeString = UnmodifiableIntIntMapTest::makeString;
            this.payloads.appendString = UnmodifiableIntIntMapTest::appendString;
            this.payloads.select = UnmodifiableIntIntMapTest::select;
            this.payloads.reject = UnmodifiableIntIntMapTest::reject;
            this.payloads.select_value = UnmodifiableIntIntMapTest::select_value;
            this.payloads.reject_value = UnmodifiableIntIntMapTest::reject_value;
            this.payloads.collect = UnmodifiableIntIntMapTest::collect;
            this.payloads.count = UnmodifiableIntIntMapTest::count;
            this.payloads.detectIfNone_value = UnmodifiableIntIntMapTest::detectIfNone_value;
            this.payloads.anySatisfy = UnmodifiableIntIntMapTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableIntIntMapTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableIntIntMapTest::noneSatisfy;
            this.payloads.max = UnmodifiableIntIntMapTest::max;
            this.payloads.min = UnmodifiableIntIntMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableIntIntMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableIntIntMapTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableIntIntMapTest::sum;
            this.payloads.average = UnmodifiableIntIntMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = UnmodifiableIntIntMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = UnmodifiableIntIntMapTest::toList;
            this.payloads.toSortedList = UnmodifiableIntIntMapTest::toSortedList;
            this.payloads.toSet = UnmodifiableIntIntMapTest::toSet;
            this.payloads.toBag = UnmodifiableIntIntMapTest::toBag;
            this.payloads.intIterator = UnmodifiableIntIntMapTest::intIterator;
            this.payloads.asLazy = UnmodifiableIntIntMapTest::asLazy;
            this.payloads.keysView = UnmodifiableIntIntMapTest::keysView;
            this.payloads.keyValuesView = UnmodifiableIntIntMapTest::keyValuesView;
            this.payloads.toSortedArray = UnmodifiableIntIntMapTest::toSortedArray;
            this.payloads.toArray = UnmodifiableIntIntMapTest::toArray;
            this.payloads.toImmutable = UnmodifiableIntIntMapTest::toImmutable;
            this.payloads.chunk = UnmodifiableIntIntMapTest::chunk;
            this.payloads.put_every_slot = UnmodifiableIntIntMapTest::put_every_slot;
            this.payloads.asSynchronized = UnmodifiableIntIntMapTest::asSynchronized;
            this.payloads.serialize = UnmodifiableIntIntMapTest::serialize;
            this.payloads.serializeKeySet = UnmodifiableIntIntMapTest::serializeKeySet;
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::removeKey, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKeyIfAbsent = UnmodifiableIntIntMapTest::removeKeyIfAbsent;
            this.payloads.removeKeyIfAbsentThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::removeKeyIfAbsentThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.put = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::put, java.lang.UnsupportedOperationException.class);
            this.payloads.getAndPut = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::getAndPut, java.lang.UnsupportedOperationException.class);
            this.payloads.putPair = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::putPair, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::updateValues, java.lang.UnsupportedOperationException.class);
            this.payloads.addToValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::addToValue, java.lang.UnsupportedOperationException.class);
            this.payloads.withKeysValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::withKeysValues, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::withoutKey, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAllKeys = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::withoutAllKeys, java.lang.UnsupportedOperationException.class);
            this.payloads.withAllKeyValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::withAllKeyValues, java.lang.UnsupportedOperationException.class);
            this.payloads.putDuplicateWithRemovedSlot = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::putDuplicateWithRemovedSlot, java.lang.UnsupportedOperationException.class);
            this.payloads.get = UnmodifiableIntIntMapTest::get;
            this.payloads.getIfAbsent = UnmodifiableIntIntMapTest::getIfAbsent;
            this.payloads.getOrThrow = UnmodifiableIntIntMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = UnmodifiableIntIntMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::getIfAbsentPutThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPut_Function = UnmodifiableIntIntMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPut_FunctionThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::getIfAbsentPut_FunctionThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWith = UnmodifiableIntIntMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::getIfAbsentPutWithThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWithKey = UnmodifiableIntIntMapTest::getIfAbsentPutWithKey;
            this.payloads.freeze = UnmodifiableIntIntMapTest::freeze;
            this.payloads.getIfAbsentPutWithKeyThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::getIfAbsentPutWithKeyThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.putAllThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::putAllThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableIntIntMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableIntIntMapTest::contains;
            this.payloads.containsKey = UnmodifiableIntIntMapTest::containsKey;
            this.payloads.containsValue = UnmodifiableIntIntMapTest::containsValue;
            this.payloads.size = UnmodifiableIntIntMapTest::size;
            this.payloads.asUnmodifiable = UnmodifiableIntIntMapTest::asUnmodifiable;
            this.payloads.intIterator_with_remove = UnmodifiableIntIntMapTest::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = UnmodifiableIntIntMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = UnmodifiableIntIntMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = UnmodifiableIntIntMapTest::flipUniqueValues;
        }
    }
}
