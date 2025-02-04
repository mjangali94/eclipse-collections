/*
 * Copyright (c) 2022 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable.primitive;

import java.util.Arrays;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.map.primitive.DoubleIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleIntMap;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.primitive.DoubleIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleIntSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableDoubleIntSingletonMapTest extends AbstractImmutableDoubleIntMapTestCase {

    @Override
    protected ImmutableDoubleIntMap classUnderTest() {
        return DoubleIntMaps.immutable.with(0.0, 0);
    }

    @Test
    public void newWithKeyValue() {
        ImmutableDoubleIntMap map1 = this.classUnderTest();
        ImmutableDoubleIntMap expected = this.newWithKeysValues(0.0, 0);
        Assert.assertEquals(expected, map1.newWithKeyValue(0.0, 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0.0, 0));
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableDoubleIntMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32.0));
        Assert.assertSame(map1, map1.newWithoutKey(32.0));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableDoubleIntMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey(0.0));
        Assert.assertNotSame(map2, map2.newWithoutKey(0.0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableDoubleIntMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableDoubleIntMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(DoubleArrayList.newListWith(31.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertTrue(this.map.containsValue(0));
        Assert.assertFalse(this.map.containsValue(31));
        Assert.assertFalse(this.map.containsValue(32));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0));
        Assert.assertFalse(this.map.contains(31));
        Assert.assertFalse(this.map.contains(32));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0, 5));
        Assert.assertEquals(15L, this.map.getIfAbsent(31.0, 15));
        Assert.assertEquals(25L, this.map.getIfAbsent(32.0, 25));
    }

    @Override
    @Test
    public void asLazy() {
        Assert.assertEquals(IntArrayList.newListWith(0), this.map.asLazy().toList());
    }

    @Override
    @Test
    public void intIterator() {
        IntIterator iterator = this.map.intIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(0L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(0L, this.map.getOrThrow(0.0));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(31.0));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(32.0));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0L, this.map.get(0.0));
        Assert.assertEquals(0L, this.map.get(31.0));
        Assert.assertEquals(0L, this.map.get(32.0));
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.map.containsAll(0, 31, 32));
        Assert.assertFalse(this.map.containsAll(31, 35));
        Assert.assertTrue(this.map.containsAll(0));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey() {
        Assert.assertTrue(this.map.containsKey(0.0));
        Assert.assertFalse(this.map.containsKey(31.0));
        Assert.assertFalse(this.map.containsKey(32.0));
    }

    @Override
    @Test
    public void keysView() {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0), this.map.keysView().toSortedList());
    }

    @Override
    @Test
    public void toSortedArray() {
        Assert.assertTrue(Arrays.equals(new int[] { 0 }, this.map.toSortedArray()));
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.map.containsAll(IntArrayList.newListWith(0, 31, 32)));
        Assert.assertFalse(this.map.containsAll(IntArrayList.newListWith(0, 31, 35)));
        Assert.assertTrue(this.map.containsAll(IntArrayList.newListWith(0)));
        Assert.assertTrue(this.map.containsAll(new IntArrayList()));
    }

    @Override
    @Test
    public void select() {
        DoubleIntMap actual1 = this.classUnderTest().select((double key, int value) -> Double.compare(key, 0.0) == 0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0), actual1);
        DoubleIntMap actual2 = this.classUnderTest().select((double key, int value) -> Double.compare(key, 1.0) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject() {
        DoubleIntMap actual1 = this.classUnderTest().reject((double key, int value) -> Double.compare(key, 1.0) == 0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0), actual1);
        DoubleIntMap actual2 = this.classUnderTest().reject((double key, int value) -> Double.compare(key, 0.0) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value() {
        IntIterable actual1 = this.classUnderTest().select(IntPredicates.equal(1));
        Assert.assertEquals(IntBags.immutable.empty(), actual1);
        IntIterable actual2 = this.classUnderTest().select(IntPredicates.equal(0));
        Assert.assertEquals(IntBags.immutable.with(0), actual2);
    }

    @Override
    @Test
    public void reject_value() {
        IntIterable actual1 = this.classUnderTest().reject(IntPredicates.equal(0));
        Assert.assertEquals(IntBags.immutable.empty(), actual1);
        IntIterable actual2 = this.classUnderTest().reject(IntPredicates.equal(1));
        Assert.assertEquals(IntBags.immutable.with(0), actual2);
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count(IntPredicates.equal(1)));
        Assert.assertEquals(1, this.classUnderTest().count(IntPredicates.equal(0)));
    }

    @Test
    public void injectInto() {
        ImmutableDoubleIntSingletonMap iterable = new ImmutableDoubleIntSingletonMap(1.0, 1);
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(1), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableDoubleIntSingletonMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAllKeys);
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
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
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
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableDoubleIntSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleIntSingletonMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableDoubleIntSingletonMapTest::values;
            this.payloads.size = ImmutableDoubleIntSingletonMapTest::size;
            this.payloads.isEmpty = ImmutableDoubleIntSingletonMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableDoubleIntSingletonMapTest::notEmpty;
            this.payloads.testHashCode = ImmutableDoubleIntSingletonMapTest::testHashCode;
            this.payloads.testToString = ImmutableDoubleIntSingletonMapTest::testToString;
            this.payloads.forEach = ImmutableDoubleIntSingletonMapTest::forEach;
            this.payloads.forEachValue = ImmutableDoubleIntSingletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableDoubleIntSingletonMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableDoubleIntSingletonMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableDoubleIntSingletonMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableDoubleIntSingletonMapTest::makeString;
            this.payloads.appendString = ImmutableDoubleIntSingletonMapTest::appendString;
            this.payloads.collect = ImmutableDoubleIntSingletonMapTest::collect;
            this.payloads.detectIfNone_value = ImmutableDoubleIntSingletonMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableDoubleIntSingletonMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableDoubleIntSingletonMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableDoubleIntSingletonMapTest::noneSatisfy;
            this.payloads.max = ImmutableDoubleIntSingletonMapTest::max;
            this.payloads.min = ImmutableDoubleIntSingletonMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleIntSingletonMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleIntSingletonMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableDoubleIntSingletonMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableDoubleIntSingletonMapTest::maxIfEmpty;
            this.payloads.sum = ImmutableDoubleIntSingletonMapTest::sum;
            this.payloads.average = ImmutableDoubleIntSingletonMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleIntSingletonMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableDoubleIntSingletonMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleIntSingletonMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableDoubleIntSingletonMapTest::toList;
            this.payloads.toSortedList = ImmutableDoubleIntSingletonMapTest::toSortedList;
            this.payloads.toSet = ImmutableDoubleIntSingletonMapTest::toSet;
            this.payloads.toBag = ImmutableDoubleIntSingletonMapTest::toBag;
            this.payloads.keyValuesView = ImmutableDoubleIntSingletonMapTest::keyValuesView;
            this.payloads.toArray = ImmutableDoubleIntSingletonMapTest::toArray;
            this.payloads.toImmutable = ImmutableDoubleIntSingletonMapTest::toImmutable;
            this.payloads.chunk = ImmutableDoubleIntSingletonMapTest::chunk;
            this.payloads.testEquals = ImmutableDoubleIntSingletonMapTest::testEquals;
            this.payloads.keySet = ImmutableDoubleIntSingletonMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableDoubleIntSingletonMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableDoubleIntSingletonMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableDoubleIntSingletonMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableDoubleIntSingletonMapTest::newWithoutAllKeys;
            this.payloads.containsValue = ImmutableDoubleIntSingletonMapTest::containsValue;
            this.payloads.contains = ImmutableDoubleIntSingletonMapTest::contains;
            this.payloads.getIfAbsent = ImmutableDoubleIntSingletonMapTest::getIfAbsent;
            this.payloads.asLazy = ImmutableDoubleIntSingletonMapTest::asLazy;
            this.payloads.intIterator = ImmutableDoubleIntSingletonMapTest::intIterator;
            this.payloads.getOrThrow = ImmutableDoubleIntSingletonMapTest::getOrThrow;
            this.payloads.get = ImmutableDoubleIntSingletonMapTest::get;
            this.payloads.containsAll = ImmutableDoubleIntSingletonMapTest::containsAll;
            this.payloads.containsKey = ImmutableDoubleIntSingletonMapTest::containsKey;
            this.payloads.keysView = ImmutableDoubleIntSingletonMapTest::keysView;
            this.payloads.toSortedArray = ImmutableDoubleIntSingletonMapTest::toSortedArray;
            this.payloads.containsAll_Iterable = ImmutableDoubleIntSingletonMapTest::containsAll_Iterable;
            this.payloads.select = ImmutableDoubleIntSingletonMapTest::select;
            this.payloads.reject = ImmutableDoubleIntSingletonMapTest::reject;
            this.payloads.select_value = ImmutableDoubleIntSingletonMapTest::select_value;
            this.payloads.reject_value = ImmutableDoubleIntSingletonMapTest::reject_value;
            this.payloads.count = ImmutableDoubleIntSingletonMapTest::count;
            this.payloads.injectInto = ImmutableDoubleIntSingletonMapTest::injectInto;
        }
    }
}
