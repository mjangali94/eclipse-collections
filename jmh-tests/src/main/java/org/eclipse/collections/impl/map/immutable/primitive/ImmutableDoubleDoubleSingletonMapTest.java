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
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.map.primitive.DoubleDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleDoubleMap;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.primitive.DoubleDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleDoubleHashMap;
import org.eclipse.collections.impl.math.MutableDouble;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleDoubleSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableDoubleDoubleSingletonMapTest extends AbstractImmutableDoubleDoubleMapTestCase {

    @Override
    protected ImmutableDoubleDoubleMap classUnderTest() {
        return DoubleDoubleMaps.immutable.with(0.0, 0.0);
    }

    @Test
    public void newWithKeyValue() {
        ImmutableDoubleDoubleMap map1 = this.classUnderTest();
        ImmutableDoubleDoubleMap expected = this.newWithKeysValues(0.0, 0.0);
        Assert.assertEquals(expected, map1.newWithKeyValue(0.0, 0.0));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0.0, 0.0));
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableDoubleDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32.0));
        Assert.assertSame(map1, map1.newWithoutKey(32.0));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableDoubleDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey(0.0));
        Assert.assertNotSame(map2, map2.newWithoutKey(0.0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableDoubleDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map1);
        ImmutableDoubleDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(DoubleArrayList.newListWith(31.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertTrue(this.map.containsValue(0.0));
        Assert.assertFalse(this.map.containsValue(31.0));
        Assert.assertFalse(this.map.containsValue(32.0));
    }

    @Override
    @Test
    public void contains() {
        Assert.assertTrue(this.map.contains(0.0));
        Assert.assertFalse(this.map.contains(31.0));
        Assert.assertFalse(this.map.contains(32.0));
    }

    @Override
    @Test
    public void getIfAbsent() {
        Assert.assertEquals(0.0, this.map.getIfAbsent(0.0, 5.0), 0.0);
        Assert.assertEquals(15.0, this.map.getIfAbsent(31.0, 15.0), 0.0);
        Assert.assertEquals(25.0, this.map.getIfAbsent(32.0, 25.0), 0.0);
    }

    @Override
    @Test
    public void asLazy() {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0), this.map.asLazy().toList());
    }

    @Override
    @Test
    public void doubleIterator() {
        DoubleIterator iterator = this.map.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(0.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow() {
        Assert.assertEquals(0.0, this.map.getOrThrow(0.0), 0.0);
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(31.0));
        Assert.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(32.0));
    }

    @Override
    @Test
    public void get() {
        Assert.assertEquals(0.0, this.map.get(0.0), 0.0);
        Assert.assertEquals(0.0, this.map.get(31.0), 0.0);
        Assert.assertEquals(0.0, this.map.get(32.0), 0.0);
    }

    @Override
    @Test
    public void containsAll() {
        Assert.assertFalse(this.map.containsAll(0.0, 31.0, 32.0));
        Assert.assertFalse(this.map.containsAll(31.0, 35.0));
        Assert.assertTrue(this.map.containsAll(0.0));
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
        Assert.assertTrue(Arrays.equals(new double[] { 0.0 }, this.map.toSortedArray()));
    }

    @Override
    @Test
    public void containsAll_Iterable() {
        Assert.assertFalse(this.map.containsAll(DoubleArrayList.newListWith(0.0, 31.0, 32.0)));
        Assert.assertFalse(this.map.containsAll(DoubleArrayList.newListWith(0.0, 31.0, 35.0)));
        Assert.assertTrue(this.map.containsAll(DoubleArrayList.newListWith(0.0)));
        Assert.assertTrue(this.map.containsAll(new DoubleArrayList()));
    }

    @Override
    @Test
    public void select() {
        DoubleDoubleMap actual1 = this.classUnderTest().select((double key, double value) -> Double.compare(key, 0.0) == 0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0), actual1);
        DoubleDoubleMap actual2 = this.classUnderTest().select((double key, double value) -> Double.compare(key, 1.0) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject() {
        DoubleDoubleMap actual1 = this.classUnderTest().reject((double key, double value) -> Double.compare(key, 1.0) == 0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0), actual1);
        DoubleDoubleMap actual2 = this.classUnderTest().reject((double key, double value) -> Double.compare(key, 0.0) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value() {
        DoubleIterable actual1 = this.classUnderTest().select(DoublePredicates.equal(1.0));
        Assert.assertEquals(DoubleBags.immutable.empty(), actual1);
        DoubleIterable actual2 = this.classUnderTest().select(DoublePredicates.equal(0.0));
        Assert.assertEquals(DoubleBags.immutable.with(0.0), actual2);
    }

    @Override
    @Test
    public void reject_value() {
        DoubleIterable actual1 = this.classUnderTest().reject(DoublePredicates.equal(0.0));
        Assert.assertEquals(DoubleBags.immutable.empty(), actual1);
        DoubleIterable actual2 = this.classUnderTest().reject(DoublePredicates.equal(1.0));
        Assert.assertEquals(DoubleBags.immutable.with(0.0), actual2);
    }

    @Override
    @Test
    public void count() {
        Assert.assertEquals(0, this.classUnderTest().count(DoublePredicates.equal(1.0)));
        Assert.assertEquals(1, this.classUnderTest().count(DoublePredicates.equal(0.0)));
    }

    @Test
    public void injectInto() {
        ImmutableDoubleDoubleSingletonMap iterable = new ImmutableDoubleDoubleSingletonMap(1.0, 1.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(1.0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableDoubleDoubleSingletonMapTest instance;

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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableDoubleDoubleSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubleDoubleSingletonMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableDoubleDoubleSingletonMapTest::values;
            this.payloads.size = ImmutableDoubleDoubleSingletonMapTest::size;
            this.payloads.isEmpty = ImmutableDoubleDoubleSingletonMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableDoubleDoubleSingletonMapTest::notEmpty;
            this.payloads.testHashCode = ImmutableDoubleDoubleSingletonMapTest::testHashCode;
            this.payloads.testToString = ImmutableDoubleDoubleSingletonMapTest::testToString;
            this.payloads.forEach = ImmutableDoubleDoubleSingletonMapTest::forEach;
            this.payloads.forEachValue = ImmutableDoubleDoubleSingletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableDoubleDoubleSingletonMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableDoubleDoubleSingletonMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableDoubleDoubleSingletonMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableDoubleDoubleSingletonMapTest::makeString;
            this.payloads.appendString = ImmutableDoubleDoubleSingletonMapTest::appendString;
            this.payloads.collect = ImmutableDoubleDoubleSingletonMapTest::collect;
            this.payloads.detectIfNone_value = ImmutableDoubleDoubleSingletonMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableDoubleDoubleSingletonMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableDoubleDoubleSingletonMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableDoubleDoubleSingletonMapTest::noneSatisfy;
            this.payloads.max = ImmutableDoubleDoubleSingletonMapTest::max;
            this.payloads.min = ImmutableDoubleDoubleSingletonMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleDoubleSingletonMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleDoubleSingletonMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableDoubleDoubleSingletonMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableDoubleDoubleSingletonMapTest::maxIfEmpty;
            this.payloads.sum = ImmutableDoubleDoubleSingletonMapTest::sum;
            this.payloads.average = ImmutableDoubleDoubleSingletonMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleDoubleSingletonMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableDoubleDoubleSingletonMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableDoubleDoubleSingletonMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableDoubleDoubleSingletonMapTest::toList;
            this.payloads.toSortedList = ImmutableDoubleDoubleSingletonMapTest::toSortedList;
            this.payloads.toSet = ImmutableDoubleDoubleSingletonMapTest::toSet;
            this.payloads.toBag = ImmutableDoubleDoubleSingletonMapTest::toBag;
            this.payloads.keyValuesView = ImmutableDoubleDoubleSingletonMapTest::keyValuesView;
            this.payloads.toArray = ImmutableDoubleDoubleSingletonMapTest::toArray;
            this.payloads.toImmutable = ImmutableDoubleDoubleSingletonMapTest::toImmutable;
            this.payloads.chunk = ImmutableDoubleDoubleSingletonMapTest::chunk;
            this.payloads.testEquals = ImmutableDoubleDoubleSingletonMapTest::testEquals;
            this.payloads.keySet = ImmutableDoubleDoubleSingletonMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableDoubleDoubleSingletonMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableDoubleDoubleSingletonMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableDoubleDoubleSingletonMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableDoubleDoubleSingletonMapTest::newWithoutAllKeys;
            this.payloads.containsValue = ImmutableDoubleDoubleSingletonMapTest::containsValue;
            this.payloads.contains = ImmutableDoubleDoubleSingletonMapTest::contains;
            this.payloads.getIfAbsent = ImmutableDoubleDoubleSingletonMapTest::getIfAbsent;
            this.payloads.asLazy = ImmutableDoubleDoubleSingletonMapTest::asLazy;
            this.payloads.doubleIterator = ImmutableDoubleDoubleSingletonMapTest::doubleIterator;
            this.payloads.getOrThrow = ImmutableDoubleDoubleSingletonMapTest::getOrThrow;
            this.payloads.get = ImmutableDoubleDoubleSingletonMapTest::get;
            this.payloads.containsAll = ImmutableDoubleDoubleSingletonMapTest::containsAll;
            this.payloads.containsKey = ImmutableDoubleDoubleSingletonMapTest::containsKey;
            this.payloads.keysView = ImmutableDoubleDoubleSingletonMapTest::keysView;
            this.payloads.toSortedArray = ImmutableDoubleDoubleSingletonMapTest::toSortedArray;
            this.payloads.containsAll_Iterable = ImmutableDoubleDoubleSingletonMapTest::containsAll_Iterable;
            this.payloads.select = ImmutableDoubleDoubleSingletonMapTest::select;
            this.payloads.reject = ImmutableDoubleDoubleSingletonMapTest::reject;
            this.payloads.select_value = ImmutableDoubleDoubleSingletonMapTest::select_value;
            this.payloads.reject_value = ImmutableDoubleDoubleSingletonMapTest::reject_value;
            this.payloads.count = ImmutableDoubleDoubleSingletonMapTest::count;
            this.payloads.injectInto = ImmutableDoubleDoubleSingletonMapTest::injectInto;
        }
    }
}
