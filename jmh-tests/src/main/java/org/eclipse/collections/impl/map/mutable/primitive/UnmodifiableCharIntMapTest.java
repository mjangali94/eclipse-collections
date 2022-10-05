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
import org.eclipse.collections.api.block.function.primitive.CharToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.api.map.primitive.MutableCharIntMap;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableCharIntMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableCharIntMapTest extends AbstractMutableCharIntMapTestCase {

    private final UnmodifiableCharIntMap map = this.classUnderTest();

    @Override
    protected UnmodifiableCharIntMap classUnderTest() {
        return new UnmodifiableCharIntMap(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32));
    }

    @Override
    protected UnmodifiableCharIntMap newWithKeysValues(char key1, int value1) {
        return new UnmodifiableCharIntMap(new CharIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2) {
        return new UnmodifiableCharIntMap(new CharIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3) {
        return new UnmodifiableCharIntMap(new CharIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3, char key4, int value4) {
        return new UnmodifiableCharIntMap(new CharIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableCharIntMap getEmptyMap() {
        return new UnmodifiableCharIntMap(new CharIntHashMap());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.map.clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeKey() {
        this.map.removeKey((char) 5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.map.remove((char) 5);
    }

    @Override
    @Test
    public void removeKeyIfAbsent() {
        Assert.assertEquals(100, this.map.removeKeyIfAbsent((char) 10, 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException() {
        Assert.assertEquals(100, this.map.removeKeyIfAbsent((char) 10, 100));
        this.map.removeKeyIfAbsent((char) 0, 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put() {
        this.map.put((char) 0, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getAndPut() {
        this.map.getAndPut((char) 0, 1, 2);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair((char) 0, 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValues() {
        this.map.updateValues((k, v) -> v);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue() {
        this.map.addToValue((char) 0, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues() {
        this.map.withKeyValue((char) 1, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey() {
        this.map.withoutKey((char) 32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys() {
        this.map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAllKeyValues() {
        this.map.withAllKeyValues(Iterables.iList(PrimitiveTuples.pair((char) 1, 1)));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot() {
        char collision1 = AbstractMutableCharIntMapTestCase.generateCollisions().getFirst();
        UnmodifiableCharIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get((char) 0));
        Assert.assertEquals(31L, this.map.get((char) 31));
        Assert.assertEquals(32L, this.map.get((char) 32));
        Assert.assertEquals(0L, this.map.get((char) 1));
        Assert.assertEquals(0L, this.map.get((char) 33));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent((char) 0, 5));
        Assert.assertEquals(31L, this.map.getIfAbsent((char) 31, 5));
        Assert.assertEquals(32L, this.map.getIfAbsent((char) 32, 5));
        Assert.assertEquals(6L, this.map.getIfAbsent((char) 33, 6));
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow((char) 0));
        Assert.assertEquals(31L, this.map.getOrThrow((char) 31));
        Assert.assertEquals(32L, this.map.getOrThrow((char) 32));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 1));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 33));
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        Assert.assertEquals(0L, this.map.getIfAbsentPut((char) 0, 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException() {
        this.map.getIfAbsentPut((char) 10, 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function() {
        IntFunction0 factory = () -> 100;
        Assert.assertEquals(0L, this.map.getIfAbsentPut((char) 0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException() {
        IntFunction0 factory = () -> 100;
        this.map.getIfAbsentPut((char) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        IntFunction<String> functionLength = (String string) -> string.length();
        Assert.assertEquals(0L, this.map.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException() {
        IntFunction<String> functionLength = (String string) -> string.length();
        this.map.getIfAbsentPutWith((char) 10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey() {
        CharToIntFunction function = (char charParameter) -> (int) charParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey((char) 0, function));
    }

    @Override
    @Test
    public void freeze() {
        MutableCharIntMap mutableCharIntMap = this.classUnderTest();
        CharSet frozenSet = mutableCharIntMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException() {
        CharToIntFunction function = (char charParameter) -> (int) charParameter;
        this.map.getIfAbsentPutWithKey((char) 10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException() {
        UnmodifiableCharIntMap copyMap = new UnmodifiableCharIntMap(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue() {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        this.map.updateValue((char) 0, 0, incrementFunction);
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
        Assert.assertTrue(this.map.containsKey((char) 0));
        Assert.assertTrue(this.map.containsKey((char) 31));
        Assert.assertTrue(this.map.containsKey((char) 32));
        Assert.assertFalse(this.map.containsKey((char) 1));
        Assert.assertFalse(this.map.containsKey((char) 5));
        Assert.assertFalse(this.map.containsKey((char) 35));
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
        Assert.assertEquals(1, this.newWithKeysValues((char) 0, 0).size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 1, 1).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 1, 1, (char) 5, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 0, 0, (char) 5, 5).size());
        Assert.assertEquals(3, this.newWithKeysValues((char) 1, 1, (char) 0, 0, (char) 5, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 6, 6, (char) 5, 5).size());
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
        Verify.assertInstanceOf(UnmodifiableIntCharMap.class, this.classUnderTest().flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableCharIntMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableCharIntMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> removeKeyIfAbsentThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> getIfAbsentPutThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> getIfAbsentPut_FunctionThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> getIfAbsentPutWithThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> getIfAbsentPutWithKeyThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> putAllThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> intIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableCharIntMapTest> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = UnmodifiableCharIntMapTest::keySet;
            this.payloads.values = UnmodifiableCharIntMapTest::values;
            this.payloads.containsAll = UnmodifiableCharIntMapTest::containsAll;
            this.payloads.containsAll_Iterable = UnmodifiableCharIntMapTest::containsAll_Iterable;
            this.payloads.isEmpty = UnmodifiableCharIntMapTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableCharIntMapTest::notEmpty;
            this.payloads.testEquals = UnmodifiableCharIntMapTest::testEquals;
            this.payloads.testHashCode = UnmodifiableCharIntMapTest::testHashCode;
            this.payloads.testToString = UnmodifiableCharIntMapTest::testToString;
            this.payloads.forEach = UnmodifiableCharIntMapTest::forEach;
            this.payloads.forEachValue = UnmodifiableCharIntMapTest::forEachValue;
            this.payloads.forEachKey = UnmodifiableCharIntMapTest::forEachKey;
            this.payloads.forEachKeyValue = UnmodifiableCharIntMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnmodifiableCharIntMapTest::injectIntoKeyValue;
            this.payloads.makeString = UnmodifiableCharIntMapTest::makeString;
            this.payloads.appendString = UnmodifiableCharIntMapTest::appendString;
            this.payloads.select = UnmodifiableCharIntMapTest::select;
            this.payloads.reject = UnmodifiableCharIntMapTest::reject;
            this.payloads.select_value = UnmodifiableCharIntMapTest::select_value;
            this.payloads.reject_value = UnmodifiableCharIntMapTest::reject_value;
            this.payloads.collect = UnmodifiableCharIntMapTest::collect;
            this.payloads.count = UnmodifiableCharIntMapTest::count;
            this.payloads.detectIfNone_value = UnmodifiableCharIntMapTest::detectIfNone_value;
            this.payloads.anySatisfy = UnmodifiableCharIntMapTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableCharIntMapTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableCharIntMapTest::noneSatisfy;
            this.payloads.max = UnmodifiableCharIntMapTest::max;
            this.payloads.min = UnmodifiableCharIntMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableCharIntMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableCharIntMapTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableCharIntMapTest::sum;
            this.payloads.average = UnmodifiableCharIntMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = UnmodifiableCharIntMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = UnmodifiableCharIntMapTest::toList;
            this.payloads.toSortedList = UnmodifiableCharIntMapTest::toSortedList;
            this.payloads.toSet = UnmodifiableCharIntMapTest::toSet;
            this.payloads.toBag = UnmodifiableCharIntMapTest::toBag;
            this.payloads.intIterator = UnmodifiableCharIntMapTest::intIterator;
            this.payloads.asLazy = UnmodifiableCharIntMapTest::asLazy;
            this.payloads.keysView = UnmodifiableCharIntMapTest::keysView;
            this.payloads.keyValuesView = UnmodifiableCharIntMapTest::keyValuesView;
            this.payloads.toSortedArray = UnmodifiableCharIntMapTest::toSortedArray;
            this.payloads.toArray = UnmodifiableCharIntMapTest::toArray;
            this.payloads.toImmutable = UnmodifiableCharIntMapTest::toImmutable;
            this.payloads.chunk = UnmodifiableCharIntMapTest::chunk;
            this.payloads.put_every_slot = UnmodifiableCharIntMapTest::put_every_slot;
            this.payloads.asSynchronized = UnmodifiableCharIntMapTest::asSynchronized;
            this.payloads.serialize = UnmodifiableCharIntMapTest::serialize;
            this.payloads.serializeKeySet = UnmodifiableCharIntMapTest::serializeKeySet;
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::removeKey, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKeyIfAbsent = UnmodifiableCharIntMapTest::removeKeyIfAbsent;
            this.payloads.removeKeyIfAbsentThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::removeKeyIfAbsentThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.put = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::put, java.lang.UnsupportedOperationException.class);
            this.payloads.getAndPut = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::getAndPut, java.lang.UnsupportedOperationException.class);
            this.payloads.putPair = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::putPair, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::updateValues, java.lang.UnsupportedOperationException.class);
            this.payloads.addToValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::addToValue, java.lang.UnsupportedOperationException.class);
            this.payloads.withKeysValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::withKeysValues, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::withoutKey, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAllKeys = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::withoutAllKeys, java.lang.UnsupportedOperationException.class);
            this.payloads.withAllKeyValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::withAllKeyValues, java.lang.UnsupportedOperationException.class);
            this.payloads.putDuplicateWithRemovedSlot = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::putDuplicateWithRemovedSlot, java.lang.UnsupportedOperationException.class);
            this.payloads.get = UnmodifiableCharIntMapTest::get;
            this.payloads.getIfAbsent = UnmodifiableCharIntMapTest::getIfAbsent;
            this.payloads.getOrThrow = UnmodifiableCharIntMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = UnmodifiableCharIntMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::getIfAbsentPutThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPut_Function = UnmodifiableCharIntMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPut_FunctionThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::getIfAbsentPut_FunctionThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWith = UnmodifiableCharIntMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::getIfAbsentPutWithThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWithKey = UnmodifiableCharIntMapTest::getIfAbsentPutWithKey;
            this.payloads.freeze = UnmodifiableCharIntMapTest::freeze;
            this.payloads.getIfAbsentPutWithKeyThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::getIfAbsentPutWithKeyThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.putAllThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::putAllThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableCharIntMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableCharIntMapTest::contains;
            this.payloads.containsKey = UnmodifiableCharIntMapTest::containsKey;
            this.payloads.containsValue = UnmodifiableCharIntMapTest::containsValue;
            this.payloads.size = UnmodifiableCharIntMapTest::size;
            this.payloads.asUnmodifiable = UnmodifiableCharIntMapTest::asUnmodifiable;
            this.payloads.intIterator_with_remove = UnmodifiableCharIntMapTest::intIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = UnmodifiableCharIntMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = UnmodifiableCharIntMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = UnmodifiableCharIntMapTest::flipUniqueValues;
        }
    }
}
