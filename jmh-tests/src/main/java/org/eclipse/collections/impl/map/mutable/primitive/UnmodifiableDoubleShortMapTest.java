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

import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToShortFunction;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.api.map.primitive.MutableDoubleShortMap;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableDoubleShortMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableDoubleShortMapTest extends AbstractMutableDoubleShortMapTestCase {

    private final UnmodifiableDoubleShortMap map = this.classUnderTest();

    @Override
    protected UnmodifiableDoubleShortMap classUnderTest() {
        return new UnmodifiableDoubleShortMap(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32));
    }

    @Override
    protected UnmodifiableDoubleShortMap newWithKeysValues(double key1, short value1) {
        return new UnmodifiableDoubleShortMap(new DoubleShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2) {
        return new UnmodifiableDoubleShortMap(new DoubleShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3) {
        return new UnmodifiableDoubleShortMap(new DoubleShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3, double key4, short value4) {
        return new UnmodifiableDoubleShortMap(new DoubleShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableDoubleShortMap getEmptyMap() {
        return new UnmodifiableDoubleShortMap(new DoubleShortHashMap());
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
        Assert.assertEquals((short) 100, this.map.removeKeyIfAbsent(10.0, (short) 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException() {
        Assert.assertEquals((short) 100, this.map.removeKeyIfAbsent(10.0, (short) 100));
        this.map.removeKeyIfAbsent(0.0, (short) 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put() {
        this.map.put(0.0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void getAndPut() {
        this.map.getAndPut(0.0, (short) 1, (short) 2);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair() {
        this.map.putPair(PrimitiveTuples.pair(0.0, (short) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValues() {
        this.map.updateValues((k, v) -> v);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue() {
        this.map.addToValue(0.0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues() {
        this.map.withKeyValue(1.0, (short) 1);
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
        this.map.withAllKeyValues(Iterables.iList(PrimitiveTuples.pair(1.0, (short) 1)));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot() {
        double collision1 = AbstractMutableDoubleShortMapTestCase.generateCollisions().getFirst();
        UnmodifiableDoubleShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get(0.0));
        Assert.assertEquals(31L, this.map.get(31.0));
        Assert.assertEquals(32L, this.map.get(32.0));
        Assert.assertEquals(0L, this.map.get(1.0));
        Assert.assertEquals(0L, this.map.get(33.0));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0, (short) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31.0, (short) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32.0, (short) 5));
        Assert.assertEquals(6L, this.map.getIfAbsent(33.0, (short) 6));
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow(0.0));
        Assert.assertEquals(31L, this.map.getOrThrow(31.0));
        Assert.assertEquals(32L, this.map.getOrThrow(32.0));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1.0));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33.0));
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0.0, (short) 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException() {
        this.map.getIfAbsentPut(10.0, (short) 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function() {
        ShortFunction0 factory = () -> (short) 100;
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0.0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException() {
        ShortFunction0 factory = () -> (short) 100;
        this.map.getIfAbsentPut(10.0, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();
        Assert.assertEquals(0L, this.map.getIfAbsentPutWith(0.0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException() {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();
        this.map.getIfAbsentPutWith(10.0, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey() {
        DoubleToShortFunction function = (double doubleParameter) -> (short) doubleParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey(0.0, function));
    }

    @Override
    @Test
    public void freeze() {
        MutableDoubleShortMap mutableDoubleShortMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleShortMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException() {
        DoubleToShortFunction function = (double doubleParameter) -> (short) doubleParameter;
        this.map.getIfAbsentPutWithKey(10.0, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException() {
        UnmodifiableDoubleShortMap copyMap = new UnmodifiableDoubleShortMap(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue() {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        this.map.updateValue(0.0, (short) 0, incrementFunction);
    }

    @Override
    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains((short) 0));
        Assert.assertTrue(this.map.contains((short) 31));
        Assert.assertTrue(this.map.contains((short) 32));
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
        Assert.assertTrue(this.map.containsValue((short) 0));
        Assert.assertTrue(this.map.containsValue((short) 31));
        Assert.assertTrue(this.map.containsValue((short) 32));
    }

    @Override
    @Test
    public void size() {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0.0, (short) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0, (short) 1).size());
        Assert.assertEquals(2, this.newWithKeysValues(1.0, (short) 1, 5.0, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0, (short) 0, 5.0, (short) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0, (short) 1, 0.0, (short) 0, 5.0, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0, (short) 6, 5.0, (short) 5).size());
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
    public void shortIterator_with_remove() {
        MutableShortIterator iterator = this.map.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Assert.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next() {
        MutableShortIterator iterator = this.map.shortIterator();
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
        Verify.assertInstanceOf(UnmodifiableShortDoubleMap.class, this.classUnderTest().flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private UnmodifiableDoubleShortMapTest instance;

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
        public void benchmark_shortIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator);
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
        public void benchmark_shortIterator_with_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.shortIterator_with_remove);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> payload) throws java.lang.Throwable {
            this.instance = new UnmodifiableDoubleShortMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> put_every_slot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> serialize;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> serializeKeySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> removeKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> removeKeyIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> removeKeyIfAbsentThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> getAndPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> putPair;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> updateValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> addToValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> withKeysValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> withAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> putDuplicateWithRemovedSlot;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> getIfAbsentPutThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> getIfAbsentPut_Function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> getIfAbsentPut_FunctionThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> getIfAbsentPutWithThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> getIfAbsentPutWithKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> freeze;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> getIfAbsentPutWithKeyThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> putAllThrowsException;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> shortIterator_with_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> iterator_throws_on_invocation_of_remove_before_next;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> iterator_throws_on_consecutive_invocation_of_remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<UnmodifiableDoubleShortMapTest> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.keySet = UnmodifiableDoubleShortMapTest::keySet;
            this.payloads.values = UnmodifiableDoubleShortMapTest::values;
            this.payloads.containsAll = UnmodifiableDoubleShortMapTest::containsAll;
            this.payloads.containsAll_Iterable = UnmodifiableDoubleShortMapTest::containsAll_Iterable;
            this.payloads.isEmpty = UnmodifiableDoubleShortMapTest::isEmpty;
            this.payloads.notEmpty = UnmodifiableDoubleShortMapTest::notEmpty;
            this.payloads.testEquals = UnmodifiableDoubleShortMapTest::testEquals;
            this.payloads.testHashCode = UnmodifiableDoubleShortMapTest::testHashCode;
            this.payloads.testToString = UnmodifiableDoubleShortMapTest::testToString;
            this.payloads.forEach = UnmodifiableDoubleShortMapTest::forEach;
            this.payloads.forEachValue = UnmodifiableDoubleShortMapTest::forEachValue;
            this.payloads.forEachKey = UnmodifiableDoubleShortMapTest::forEachKey;
            this.payloads.forEachKeyValue = UnmodifiableDoubleShortMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = UnmodifiableDoubleShortMapTest::injectIntoKeyValue;
            this.payloads.makeString = UnmodifiableDoubleShortMapTest::makeString;
            this.payloads.appendString = UnmodifiableDoubleShortMapTest::appendString;
            this.payloads.select = UnmodifiableDoubleShortMapTest::select;
            this.payloads.reject = UnmodifiableDoubleShortMapTest::reject;
            this.payloads.select_value = UnmodifiableDoubleShortMapTest::select_value;
            this.payloads.reject_value = UnmodifiableDoubleShortMapTest::reject_value;
            this.payloads.collect = UnmodifiableDoubleShortMapTest::collect;
            this.payloads.count = UnmodifiableDoubleShortMapTest::count;
            this.payloads.detectIfNone_value = UnmodifiableDoubleShortMapTest::detectIfNone_value;
            this.payloads.anySatisfy = UnmodifiableDoubleShortMapTest::anySatisfy;
            this.payloads.allSatisfy = UnmodifiableDoubleShortMapTest::allSatisfy;
            this.payloads.noneSatisfy = UnmodifiableDoubleShortMapTest::noneSatisfy;
            this.payloads.max = UnmodifiableDoubleShortMapTest::max;
            this.payloads.min = UnmodifiableDoubleShortMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = UnmodifiableDoubleShortMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = UnmodifiableDoubleShortMapTest::maxIfEmpty;
            this.payloads.sum = UnmodifiableDoubleShortMapTest::sum;
            this.payloads.average = UnmodifiableDoubleShortMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = UnmodifiableDoubleShortMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = UnmodifiableDoubleShortMapTest::toList;
            this.payloads.toSortedList = UnmodifiableDoubleShortMapTest::toSortedList;
            this.payloads.toSet = UnmodifiableDoubleShortMapTest::toSet;
            this.payloads.toBag = UnmodifiableDoubleShortMapTest::toBag;
            this.payloads.shortIterator = UnmodifiableDoubleShortMapTest::shortIterator;
            this.payloads.asLazy = UnmodifiableDoubleShortMapTest::asLazy;
            this.payloads.keysView = UnmodifiableDoubleShortMapTest::keysView;
            this.payloads.keyValuesView = UnmodifiableDoubleShortMapTest::keyValuesView;
            this.payloads.toSortedArray = UnmodifiableDoubleShortMapTest::toSortedArray;
            this.payloads.toArray = UnmodifiableDoubleShortMapTest::toArray;
            this.payloads.toImmutable = UnmodifiableDoubleShortMapTest::toImmutable;
            this.payloads.chunk = UnmodifiableDoubleShortMapTest::chunk;
            this.payloads.put_every_slot = UnmodifiableDoubleShortMapTest::put_every_slot;
            this.payloads.asSynchronized = UnmodifiableDoubleShortMapTest::asSynchronized;
            this.payloads.serialize = UnmodifiableDoubleShortMapTest::serialize;
            this.payloads.serializeKeySet = UnmodifiableDoubleShortMapTest::serializeKeySet;
            this.payloads.clear = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::clear, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::removeKey, java.lang.UnsupportedOperationException.class);
            this.payloads.remove = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::remove, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKeyIfAbsent = UnmodifiableDoubleShortMapTest::removeKeyIfAbsent;
            this.payloads.removeKeyIfAbsentThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::removeKeyIfAbsentThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.put = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::put, java.lang.UnsupportedOperationException.class);
            this.payloads.getAndPut = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::getAndPut, java.lang.UnsupportedOperationException.class);
            this.payloads.putPair = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::putPair, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::updateValues, java.lang.UnsupportedOperationException.class);
            this.payloads.addToValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::addToValue, java.lang.UnsupportedOperationException.class);
            this.payloads.withKeysValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::withKeysValues, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutKey = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::withoutKey, java.lang.UnsupportedOperationException.class);
            this.payloads.withoutAllKeys = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::withoutAllKeys, java.lang.UnsupportedOperationException.class);
            this.payloads.withAllKeyValues = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::withAllKeyValues, java.lang.UnsupportedOperationException.class);
            this.payloads.putDuplicateWithRemovedSlot = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::putDuplicateWithRemovedSlot, java.lang.UnsupportedOperationException.class);
            this.payloads.get = UnmodifiableDoubleShortMapTest::get;
            this.payloads.getIfAbsent = UnmodifiableDoubleShortMapTest::getIfAbsent;
            this.payloads.getOrThrow = UnmodifiableDoubleShortMapTest::getOrThrow;
            this.payloads.getIfAbsentPut = UnmodifiableDoubleShortMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::getIfAbsentPutThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPut_Function = UnmodifiableDoubleShortMapTest::getIfAbsentPut_Function;
            this.payloads.getIfAbsentPut_FunctionThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::getIfAbsentPut_FunctionThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWith = UnmodifiableDoubleShortMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsentPutWithThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::getIfAbsentPutWithThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.getIfAbsentPutWithKey = UnmodifiableDoubleShortMapTest::getIfAbsentPutWithKey;
            this.payloads.freeze = UnmodifiableDoubleShortMapTest::freeze;
            this.payloads.getIfAbsentPutWithKeyThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::getIfAbsentPutWithKeyThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.putAllThrowsException = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::putAllThrowsException, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(UnmodifiableDoubleShortMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.contains = UnmodifiableDoubleShortMapTest::contains;
            this.payloads.containsKey = UnmodifiableDoubleShortMapTest::containsKey;
            this.payloads.containsValue = UnmodifiableDoubleShortMapTest::containsValue;
            this.payloads.size = UnmodifiableDoubleShortMapTest::size;
            this.payloads.asUnmodifiable = UnmodifiableDoubleShortMapTest::asUnmodifiable;
            this.payloads.shortIterator_with_remove = UnmodifiableDoubleShortMapTest::shortIterator_with_remove;
            this.payloads.iterator_throws_on_invocation_of_remove_before_next = UnmodifiableDoubleShortMapTest::iterator_throws_on_invocation_of_remove_before_next;
            this.payloads.iterator_throws_on_consecutive_invocation_of_remove = UnmodifiableDoubleShortMapTest::iterator_throws_on_consecutive_invocation_of_remove;
            this.payloads.flipUniqueValues = UnmodifiableDoubleShortMapTest::flipUniqueValues;
        }
    }
}
