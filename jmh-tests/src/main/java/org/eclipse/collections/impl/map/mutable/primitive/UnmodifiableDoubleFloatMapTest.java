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
import org.eclipse.collections.api.block.function.primitive.DoubleToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.api.map.primitive.MutableDoubleFloatMap;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableDoubleFloatMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableDoubleFloatMapTest extends AbstractMutableDoubleFloatMapTestCase {

    private final UnmodifiableDoubleFloatMap map = this.classUnderTest();

    @Override
    protected UnmodifiableDoubleFloatMap classUnderTest() {
        return new UnmodifiableDoubleFloatMap(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 31.0, 31.0f, 32.0, 32.0f));
    }

    @Override
    protected UnmodifiableDoubleFloatMap newWithKeysValues(double key1, float value1) {
        return new UnmodifiableDoubleFloatMap(new DoubleFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2) {
        return new UnmodifiableDoubleFloatMap(new DoubleFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3) {
        return new UnmodifiableDoubleFloatMap(new DoubleFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableDoubleFloatMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3, double key4, float value4) {
        return new UnmodifiableDoubleFloatMap(new DoubleFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableDoubleFloatMap getEmptyMap() {
        return new UnmodifiableDoubleFloatMap(new DoubleFloatHashMap());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear() {
        this.map.clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeKey() {
        this.map.removeKey(5.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        this.map.remove(5.0);
    }

    @Override
    @Test
    public void removeKeyIfAbsent() {
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent(10.0, 100.0f), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException() {
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent(10.0, 100.0f), 0.0);
        this.map.removeKeyIfAbsent(0.0, 100.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put() {
        this.map.put(0.0, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getAndPut() {
        this.map.getAndPut(0.0, 1.0f, 2.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair(0.0, 1.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValues() {
        this.map.updateValues((k, v) -> v);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue() {
        this.map.addToValue(0.0, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues() {
        this.map.withKeyValue(1.0, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey() {
        this.map.withoutKey(32.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys() {
        this.map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAllKeyValues() {
        this.map.withAllKeyValues(Iterables.iList(PrimitiveTuples.pair(1.0, 1.0f)));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot() {
        double collision1 = AbstractMutableDoubleFloatMapTestCase.generateCollisions().getFirst();
        UnmodifiableDoubleFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0.0, this.map.get(0.0), 0.0);
        Assert.assertEquals(31.0, this.map.get(31.0), 0.0);
        Assert.assertEquals(32.0, this.map.get(32.0), 0.0);
        Assert.assertEquals(0.0, this.map.get(1.0), 0.0);
        Assert.assertEquals(0.0, this.map.get(33.0), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0.0, this.map.getIfAbsent(0.0, 5.0f), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent(31.0, 5.0f), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent(32.0, 5.0f), 0.0);
        Assert.assertEquals(6.0, this.map.getIfAbsent(33.0, 6.0f), 0.0);
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(0.0, this.map.getOrThrow(0.0), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow(31.0), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow(32.0), 0.0);
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1.0));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33.0));
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        Assert.assertEquals(0.0, this.map.getIfAbsentPut(0.0, 50.0f), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException() {
        this.map.getIfAbsentPut(10.0, 100.0f);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function() {
        FloatFunction0 factory = () -> 100.0f;
        Assert.assertEquals(0.0, this.map.getIfAbsentPut(0.0, factory), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException() {
        FloatFunction0 factory = () -> 100.0f;
        this.map.getIfAbsentPut(10.0, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        Assert.assertEquals(0.0, this.map.getIfAbsentPutWith(0.0, functionLength, "123456789"), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException() {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        this.map.getIfAbsentPutWith(10.0, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey() {
        DoubleToFloatFunction function = (double doubleParameter) -> (float) doubleParameter;
        Assert.assertEquals(0.0, this.map.getIfAbsentPutWithKey(0.0, function), 0.0);
    }

    @Override
    @Test
    public void freeze() {
        MutableDoubleFloatMap mutableDoubleFloatMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleFloatMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException() {
        DoubleToFloatFunction function = (double doubleParameter) -> (float) doubleParameter;
        this.map.getIfAbsentPutWithKey(10.0, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException() {
        UnmodifiableDoubleFloatMap copyMap = new UnmodifiableDoubleFloatMap(DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 31.0, 31.0f, 32.0, 32.0f));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue() {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        this.map.updateValue(0.0, 0.0f, incrementFunction);
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
        Assert.assertTrue(this.map.containsKey(0.0));
        Assert.assertTrue(this.map.containsKey(31.0));
        Assert.assertTrue(this.map.containsKey(32.0));
        Assert.assertFalse(this.map.containsKey(1.0));
        Assert.assertFalse(this.map.containsKey(5.0));
        Assert.assertFalse(this.map.containsKey(35.0));
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
        Assert.assertEquals(1, this.newWithKeysValues(0.0, 0.0f).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0, 1.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues(1.0, 1.0f, 5.0, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0, 0.0f, 5.0, 5.0f).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0, 1.0f, 0.0, 0.0f, 5.0, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0, 6.0f, 5.0, 5.0f).size());
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
        Verify.assertInstanceOf(UnmodifiableFloatDoubleMap.class, this.classUnderTest().flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableDoubleFloatMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableDoubleFloatMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> removeKeyIfAbsentThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> getIfAbsentPutThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> getIfAbsentPut_FunctionThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> getIfAbsentPutWithThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> getIfAbsentPutWithKeyThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> putAllThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> floatIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleFloatMapTest> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = UnmodifiableDoubleFloatMapTest::keySet;
            this.payloads.values = UnmodifiableDoubleFloatMapTest::values;
            this.payloads.containsAll = UnmodifiableDoubleFloatMapTest::containsAll;
            this.payloads.containsAll_Iterable = UnmodifiableDoubleFloatMapTest::containsAll_Iterable;
            this.payloads.isEmpty = UnmodifiableDoubleFloatMapTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableDoubleFloatMapTest::notEmpty;
            this.payloads.testEquals = UnmodifiableDoubleFloatMapTest::testEquals;
            this.payloads.testHashCode = UnmodifiableDoubleFloatMapTest::testHashCode;
            this.payloads.testToString = UnmodifiableDoubleFloatMapTest::testToString;
            this.payloads.forEach = UnmodifiableDoubleFloatMapTest::forEach;
            this.payloads.forEachValue = UnmodifiableDoubleFloatMapTest::forEachValue;
            this.payloads.forEachKey = UnmodifiableDoubleFloatMapTest::forEachKey;
            this.payloads.forEachKeyValue = UnmodifiableDoubleFloatMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnmodifiableDoubleFloatMapTest::injectIntoKeyValue;
            this.payloads.makeString = UnmodifiableDoubleFloatMapTest::makeString;
            this.payloads.appendString = UnmodifiableDoubleFloatMapTest::appendString;
            this.payloads.select = UnmodifiableDoubleFloatMapTest::select;
            this.payloads.reject = UnmodifiableDoubleFloatMapTest::reject;
            this.payloads.select_value = UnmodifiableDoubleFloatMapTest::select_value;
            this.payloads.reject_value = UnmodifiableDoubleFloatMapTest::reject_value;
            this.payloads.collect = UnmodifiableDoubleFloatMapTest::collect;
            this.payloads.count = UnmodifiableDoubleFloatMapTest::count;
            this.payloads.detectIfNone_value = UnmodifiableDoubleFloatMapTest::detectIfNone_value;
            this.payloads.anySatisfy = UnmodifiableDoubleFloatMapTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableDoubleFloatMapTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableDoubleFloatMapTest::noneSatisfy;
            this.payloads.max = UnmodifiableDoubleFloatMapTest::max;
            this.payloads.min = UnmodifiableDoubleFloatMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableDoubleFloatMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableDoubleFloatMapTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableDoubleFloatMapTest::sum;
            this.payloads.average = UnmodifiableDoubleFloatMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = UnmodifiableDoubleFloatMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = UnmodifiableDoubleFloatMapTest::toList;
            this.payloads.toSortedList = UnmodifiableDoubleFloatMapTest::toSortedList;
            this.payloads.toSet = UnmodifiableDoubleFloatMapTest::toSet;
            this.payloads.toBag = UnmodifiableDoubleFloatMapTest::toBag;
            this.payloads.floatIterator = UnmodifiableDoubleFloatMapTest::floatIterator;
            this.payloads.asLazy = UnmodifiableDoubleFloatMapTest::asLazy;
            this.payloads.keysView = UnmodifiableDoubleFloatMapTest::keysView;
            this.payloads.keyValuesView = UnmodifiableDoubleFloatMapTest::keyValuesView;
            this.payloads.toSortedArray = UnmodifiableDoubleFloatMapTest::toSortedArray;
            this.payloads.toArray = UnmodifiableDoubleFloatMapTest::toArray;
            this.payloads.toImmutable = UnmodifiableDoubleFloatMapTest::toImmutable;
            this.payloads.chunk = UnmodifiableDoubleFloatMapTest::chunk;
            this.payloads.put_every_slot = UnmodifiableDoubleFloatMapTest::put_every_slot;
            this.payloads.asSynchronized = UnmodifiableDoubleFloatMapTest::asSynchronized;
            this.payloads.serialize = UnmodifiableDoubleFloatMapTest::serialize;
            this.payloads.serializeKeySet = UnmodifiableDoubleFloatMapTest::serializeKeySet;
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::removeKey, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKeyIfAbsent = UnmodifiableDoubleFloatMapTest::removeKeyIfAbsent;
            this.payloads.removeKeyIfAbsentThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::removeKeyIfAbsentThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.put = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::put, java.lang.UnsupportedOperationException.class);
            this.payloads.getAndPut = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::getAndPut, java.lang.UnsupportedOperationException.class);
            this.payloads.putPair = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::putPair, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::updateValues, java.lang.UnsupportedOperationException.class);
            this.payloads.addToValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::addToValue, java.lang.UnsupportedOperationException.class);
            this.payloads.withKeysValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::withKeysValues, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::withoutKey, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAllKeys = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::withoutAllKeys, java.lang.UnsupportedOperationException.class);
            this.payloads.withAllKeyValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::withAllKeyValues, java.lang.UnsupportedOperationException.class);
            this.payloads.putDuplicateWithRemovedSlot = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::putDuplicateWithRemovedSlot, java.lang.UnsupportedOperationException.class);
            this.payloads.get = UnmodifiableDoubleFloatMapTest::get;
            this.payloads.getIfAbsent = UnmodifiableDoubleFloatMapTest::getIfAbsent;
            this.payloads.getOrThrow = UnmodifiableDoubleFloatMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = UnmodifiableDoubleFloatMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::getIfAbsentPutThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPut_Function = UnmodifiableDoubleFloatMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPut_FunctionThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::getIfAbsentPut_FunctionThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWith = UnmodifiableDoubleFloatMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::getIfAbsentPutWithThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWithKey = UnmodifiableDoubleFloatMapTest::getIfAbsentPutWithKey;
            this.payloads.freeze = UnmodifiableDoubleFloatMapTest::freeze;
            this.payloads.getIfAbsentPutWithKeyThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::getIfAbsentPutWithKeyThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.putAllThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::putAllThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleFloatMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableDoubleFloatMapTest::contains;
            this.payloads.containsKey = UnmodifiableDoubleFloatMapTest::containsKey;
            this.payloads.containsValue = UnmodifiableDoubleFloatMapTest::containsValue;
            this.payloads.size = UnmodifiableDoubleFloatMapTest::size;
            this.payloads.asUnmodifiable = UnmodifiableDoubleFloatMapTest::asUnmodifiable;
            this.payloads.floatIterator_with_remove = UnmodifiableDoubleFloatMapTest::floatIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = UnmodifiableDoubleFloatMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = UnmodifiableDoubleFloatMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = UnmodifiableDoubleFloatMapTest::flipUniqueValues;
        }
    }
}
