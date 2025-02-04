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

import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.api.map.primitive.MutableFloatFloatMap;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableFloatFloatMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableFloatFloatMapTest extends AbstractMutableFloatFloatMapTestCase {

    private final UnmodifiableFloatFloatMap map = this.classUnderTest();

    @Override
    protected UnmodifiableFloatFloatMap classUnderTest() {
        return new UnmodifiableFloatFloatMap(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 31.0f, 31.0f, 32.0f, 32.0f));
    }

    @Override
    protected UnmodifiableFloatFloatMap newWithKeysValues(float key1, float value1) {
        return new UnmodifiableFloatFloatMap(new FloatFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2) {
        return new UnmodifiableFloatFloatMap(new FloatFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3) {
        return new UnmodifiableFloatFloatMap(new FloatFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3, float key4, float value4) {
        return new UnmodifiableFloatFloatMap(new FloatFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableFloatFloatMap getEmptyMap() {
        return new UnmodifiableFloatFloatMap(new FloatFloatHashMap());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.map.clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeKey() {
        this.map.removeKey(5.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.map.remove(5.0f);
    }

    @Override
    @Test
    public void removeKeyIfAbsent() {
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent(10.0f, 100.0f), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException() {
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent(10.0f, 100.0f), 0.0);
        this.map.removeKeyIfAbsent(0.0f, 100.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put() {
        this.map.put(0.0f, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getAndPut() {
        this.map.getAndPut(0.0f, 1.0f, 2.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair(0.0f, 1.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValues() {
        this.map.updateValues((k, v) -> v);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue() {
        this.map.addToValue(0.0f, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues() {
        this.map.withKeyValue(1.0f, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey() {
        this.map.withoutKey(32.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys() {
        this.map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAllKeyValues() {
        this.map.withAllKeyValues(Iterables.iList(PrimitiveTuples.pair(1.0f, 1.0f)));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot() {
        float collision1 = AbstractMutableFloatFloatMapTestCase.generateCollisions().getFirst();
        UnmodifiableFloatFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0.0, this.map.get(0.0f), 0.0);
        Assert.assertEquals(31.0, this.map.get(31.0f), 0.0);
        Assert.assertEquals(32.0, this.map.get(32.0f), 0.0);
        Assert.assertEquals(0.0, this.map.get(1.0f), 0.0);
        Assert.assertEquals(0.0, this.map.get(33.0f), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0.0, this.map.getIfAbsent(0.0f, 5.0f), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent(31.0f, 5.0f), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent(32.0f, 5.0f), 0.0);
        Assert.assertEquals(6.0, this.map.getIfAbsent(33.0f, 6.0f), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(0.0, this.map.getOrThrow(0.0f), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow(31.0f), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow(32.0f), 0.0);
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1.0f));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33.0f));
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        Assert.assertEquals(0.0, this.map.getIfAbsentPut(0.0f, 50.0f), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException() {
        this.map.getIfAbsentPut(10.0f, 100.0f);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function() {
        FloatFunction0 factory = () -> 100.0f;
        Assert.assertEquals(0.0, this.map.getIfAbsentPut(0.0f, factory), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException() {
        FloatFunction0 factory = () -> 100.0f;
        this.map.getIfAbsentPut(10.0f, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        Assert.assertEquals(0.0, this.map.getIfAbsentPutWith(0.0f, functionLength, "123456789"), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException() {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        this.map.getIfAbsentPutWith(10.0f, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey() {
        FloatToFloatFunction function = (float floatParameter) -> floatParameter;
        Assert.assertEquals(0.0, this.map.getIfAbsentPutWithKey(0.0f, function), 0.0);
    }

    @Override
    @Test
    public void freeze() {
        MutableFloatFloatMap mutableFloatFloatMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatFloatMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException() {
        FloatToFloatFunction function = (float floatParameter) -> floatParameter;
        this.map.getIfAbsentPutWithKey(10.0f, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException() {
        UnmodifiableFloatFloatMap copyMap = new UnmodifiableFloatFloatMap(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 31.0f, 31.0f, 32.0f, 32.0f));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        this.map.updateValue(0.0f, 0.0f, incrementFunction);
    }

    @Override
    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0.0f));
        Assert.assertTrue(this.map.contains(31.0f));
        Assert.assertTrue(this.map.contains(32.0f));
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey(0.0f));
        Assert.assertTrue(this.map.containsKey(31.0f));
        Assert.assertTrue(this.map.containsKey(32.0f));
        Assert.assertFalse(this.map.containsKey(1.0f));
        Assert.assertFalse(this.map.containsKey(5.0f));
        Assert.assertFalse(this.map.containsKey(35.0f));
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertTrue(this.map.containsValue(0.0f));
        Assert.assertTrue(this.map.containsValue(31.0f));
        Assert.assertTrue(this.map.containsValue(32.0f));
    }

    @Override
    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0.0f, 0.0f).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0f, 1.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues(1.0f, 1.0f, 5.0f, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0f, 0.0f, 5.0f, 5.0f).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0f, 1.0f, 0.0f, 0.0f, 5.0f, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0f, 6.0f, 5.0f, 5.0f).size());
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
    public void floatIterator_with_remove() {
        MutableFloatIterator iterator = this.map.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next() {
        MutableFloatIterator iterator = this.map.floatIterator();
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
        Verify.assertInstanceOf(UnmodifiableFloatFloatMap.class, this.classUnderTest().flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableFloatFloatMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
        }

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
        public void benchmark_injectIntoKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoKeyValue);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_average() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.average);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_averageThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.averageThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_median() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.median);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_medianThrowsOnEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.medianThrowsOnEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_every_slot() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_every_slot);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialize() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialize);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serializeKeySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serializeKeySet);
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
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKeyIfAbsentThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKeyIfAbsentThrowsException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAndPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAndPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putPair() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putPair);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addToValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addToValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeysValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeysValues);
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
        public void benchmark_getIfAbsentPutThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutThrowsException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_Function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_Function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut_FunctionThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut_FunctionThrowsException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithThrowsException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_freeze() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.freeze);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWithKeyThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWithKeyThrowsException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAllThrowsException() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAllThrowsException);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_floatIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator_with_remove);
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
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableFloatFloatMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> removeKeyIfAbsentThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> getIfAbsentPutThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> getIfAbsentPut_FunctionThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> getIfAbsentPutWithThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> getIfAbsentPutWithKeyThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> putAllThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableFloatFloatMapTest> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = UnmodifiableFloatFloatMapTest::keySet;
            this.payloads.values = UnmodifiableFloatFloatMapTest::values;
            this.payloads.containsAll = UnmodifiableFloatFloatMapTest::containsAll;
            this.payloads.containsAll_Iterable = UnmodifiableFloatFloatMapTest::containsAll_Iterable;
            this.payloads.isEmpty = UnmodifiableFloatFloatMapTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableFloatFloatMapTest::notEmpty;
            this.payloads.testEquals = UnmodifiableFloatFloatMapTest::testEquals;
            this.payloads.testHashCode = UnmodifiableFloatFloatMapTest::testHashCode;
            this.payloads.testToString = UnmodifiableFloatFloatMapTest::testToString;
            this.payloads.forEach = UnmodifiableFloatFloatMapTest::forEach;
            this.payloads.forEachValue = UnmodifiableFloatFloatMapTest::forEachValue;
            this.payloads.forEachKey = UnmodifiableFloatFloatMapTest::forEachKey;
            this.payloads.forEachKeyValue = UnmodifiableFloatFloatMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnmodifiableFloatFloatMapTest::injectIntoKeyValue;
            this.payloads.makeString = UnmodifiableFloatFloatMapTest::makeString;
            this.payloads.appendString = UnmodifiableFloatFloatMapTest::appendString;
            this.payloads.select = UnmodifiableFloatFloatMapTest::select;
            this.payloads.reject = UnmodifiableFloatFloatMapTest::reject;
            this.payloads.select_value = UnmodifiableFloatFloatMapTest::select_value;
            this.payloads.reject_value = UnmodifiableFloatFloatMapTest::reject_value;
            this.payloads.collect = UnmodifiableFloatFloatMapTest::collect;
            this.payloads.count = UnmodifiableFloatFloatMapTest::count;
            this.payloads.detectIfNone_value = UnmodifiableFloatFloatMapTest::detectIfNone_value;
            this.payloads.anySatisfy = UnmodifiableFloatFloatMapTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableFloatFloatMapTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableFloatFloatMapTest::noneSatisfy;
            this.payloads.max = UnmodifiableFloatFloatMapTest::max;
            this.payloads.min = UnmodifiableFloatFloatMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableFloatFloatMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableFloatFloatMapTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableFloatFloatMapTest::sum;
            this.payloads.average = UnmodifiableFloatFloatMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = UnmodifiableFloatFloatMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = UnmodifiableFloatFloatMapTest::toList;
            this.payloads.toSortedList = UnmodifiableFloatFloatMapTest::toSortedList;
            this.payloads.toSet = UnmodifiableFloatFloatMapTest::toSet;
            this.payloads.toBag = UnmodifiableFloatFloatMapTest::toBag;
            this.payloads.floatIterator = UnmodifiableFloatFloatMapTest::floatIterator;
            this.payloads.asLazy = UnmodifiableFloatFloatMapTest::asLazy;
            this.payloads.keysView = UnmodifiableFloatFloatMapTest::keysView;
            this.payloads.keyValuesView = UnmodifiableFloatFloatMapTest::keyValuesView;
            this.payloads.toSortedArray = UnmodifiableFloatFloatMapTest::toSortedArray;
            this.payloads.toArray = UnmodifiableFloatFloatMapTest::toArray;
            this.payloads.toImmutable = UnmodifiableFloatFloatMapTest::toImmutable;
            this.payloads.chunk = UnmodifiableFloatFloatMapTest::chunk;
            this.payloads.put_every_slot = UnmodifiableFloatFloatMapTest::put_every_slot;
            this.payloads.asSynchronized = UnmodifiableFloatFloatMapTest::asSynchronized;
            this.payloads.serialize = UnmodifiableFloatFloatMapTest::serialize;
            this.payloads.serializeKeySet = UnmodifiableFloatFloatMapTest::serializeKeySet;
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::removeKey, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKeyIfAbsent = UnmodifiableFloatFloatMapTest::removeKeyIfAbsent;
            this.payloads.removeKeyIfAbsentThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::removeKeyIfAbsentThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.put = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::put, java.lang.UnsupportedOperationException.class);
            this.payloads.getAndPut = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::getAndPut, java.lang.UnsupportedOperationException.class);
            this.payloads.putPair = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::putPair, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::updateValues, java.lang.UnsupportedOperationException.class);
            this.payloads.addToValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::addToValue, java.lang.UnsupportedOperationException.class);
            this.payloads.withKeysValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::withKeysValues, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::withoutKey, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAllKeys = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::withoutAllKeys, java.lang.UnsupportedOperationException.class);
            this.payloads.withAllKeyValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::withAllKeyValues, java.lang.UnsupportedOperationException.class);
            this.payloads.putDuplicateWithRemovedSlot = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::putDuplicateWithRemovedSlot, java.lang.UnsupportedOperationException.class);
            this.payloads.get = UnmodifiableFloatFloatMapTest::get;
            this.payloads.getIfAbsent = UnmodifiableFloatFloatMapTest::getIfAbsent;
            this.payloads.getOrThrow = UnmodifiableFloatFloatMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = UnmodifiableFloatFloatMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::getIfAbsentPutThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPut_Function = UnmodifiableFloatFloatMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPut_FunctionThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::getIfAbsentPut_FunctionThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWith = UnmodifiableFloatFloatMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::getIfAbsentPutWithThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWithKey = UnmodifiableFloatFloatMapTest::getIfAbsentPutWithKey;
            this.payloads.freeze = UnmodifiableFloatFloatMapTest::freeze;
            this.payloads.getIfAbsentPutWithKeyThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::getIfAbsentPutWithKeyThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.putAllThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::putAllThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableFloatFloatMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableFloatFloatMapTest::contains;
            this.payloads.containsKey = UnmodifiableFloatFloatMapTest::containsKey;
            this.payloads.containsValue = UnmodifiableFloatFloatMapTest::containsValue;
            this.payloads.size = UnmodifiableFloatFloatMapTest::size;
            this.payloads.asUnmodifiable = UnmodifiableFloatFloatMapTest::asUnmodifiable;
            this.payloads.floatIterator_with_remove = UnmodifiableFloatFloatMapTest::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = UnmodifiableFloatFloatMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = UnmodifiableFloatFloatMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = UnmodifiableFloatFloatMapTest::flipUniqueValues;
        }
    }
}
