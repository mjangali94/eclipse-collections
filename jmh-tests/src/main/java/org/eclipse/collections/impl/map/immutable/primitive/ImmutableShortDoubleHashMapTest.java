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

import org.eclipse.collections.api.map.primitive.ImmutableShortDoubleMap;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ShortDoubleHashMap;
import org.eclipse.collections.impl.math.MutableDouble;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortDoubleHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableShortDoubleHashMapTest extends AbstractImmutableShortDoubleMapTestCase {

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableShortDoubleMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue() {
        ImmutableShortDoubleMap map1 = this.classUnderTest();
        ImmutableShortDoubleMap expected = this.newWithKeysValues((short) 0, 0.0, (short) 31, 31.0, (short) 32, 32.0, (short) 33, 33.0);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 33, 33.0));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 33, 33.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableShortDoubleMap map1 = this.classUnderTest();
        ImmutableShortDoubleMap expected = this.newWithKeysValues((short) 0, 0.0, (short) 31, 31.0);
        Assert.assertEquals(expected, map1.newWithoutKey((short) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableShortDoubleMap map1 = this.classUnderTest();
        ImmutableShortDoubleMap expected = this.newWithKeysValues((short) 31, 31.0);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto() {
        ImmutableShortDoubleHashMap iterable = new ImmutableShortDoubleHashMap(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0));
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(6.0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableShortDoubleHashMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
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
        public void benchmark_containsAll_Iterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll_Iterable);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableShortDoubleHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableShortDoubleHashMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableShortDoubleHashMapTest::values;
            this.payloads.get = ImmutableShortDoubleHashMapTest::get;
            this.payloads.getIfAbsent = ImmutableShortDoubleHashMapTest::getIfAbsent;
            this.payloads.getOrThrow = ImmutableShortDoubleHashMapTest::getOrThrow;
            this.payloads.containsKey = ImmutableShortDoubleHashMapTest::containsKey;
            this.payloads.containsValue = ImmutableShortDoubleHashMapTest::containsValue;
            this.payloads.contains = ImmutableShortDoubleHashMapTest::contains;
            this.payloads.containsAll = ImmutableShortDoubleHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ImmutableShortDoubleHashMapTest::containsAll_Iterable;
            this.payloads.size = ImmutableShortDoubleHashMapTest::size;
            this.payloads.isEmpty = ImmutableShortDoubleHashMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableShortDoubleHashMapTest::notEmpty;
            this.payloads.testHashCode = ImmutableShortDoubleHashMapTest::testHashCode;
            this.payloads.testToString = ImmutableShortDoubleHashMapTest::testToString;
            this.payloads.forEach = ImmutableShortDoubleHashMapTest::forEach;
            this.payloads.forEachValue = ImmutableShortDoubleHashMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableShortDoubleHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableShortDoubleHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableShortDoubleHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableShortDoubleHashMapTest::makeString;
            this.payloads.appendString = ImmutableShortDoubleHashMapTest::appendString;
            this.payloads.select = ImmutableShortDoubleHashMapTest::select;
            this.payloads.reject = ImmutableShortDoubleHashMapTest::reject;
            this.payloads.select_value = ImmutableShortDoubleHashMapTest::select_value;
            this.payloads.reject_value = ImmutableShortDoubleHashMapTest::reject_value;
            this.payloads.collect = ImmutableShortDoubleHashMapTest::collect;
            this.payloads.count = ImmutableShortDoubleHashMapTest::count;
            this.payloads.detectIfNone_value = ImmutableShortDoubleHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableShortDoubleHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableShortDoubleHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableShortDoubleHashMapTest::noneSatisfy;
            this.payloads.max = ImmutableShortDoubleHashMapTest::max;
            this.payloads.min = ImmutableShortDoubleHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortDoubleHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortDoubleHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableShortDoubleHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableShortDoubleHashMapTest::maxIfEmpty;
            this.payloads.sum = ImmutableShortDoubleHashMapTest::sum;
            this.payloads.average = ImmutableShortDoubleHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortDoubleHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableShortDoubleHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableShortDoubleHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableShortDoubleHashMapTest::toList;
            this.payloads.toSortedList = ImmutableShortDoubleHashMapTest::toSortedList;
            this.payloads.toSet = ImmutableShortDoubleHashMapTest::toSet;
            this.payloads.toBag = ImmutableShortDoubleHashMapTest::toBag;
            this.payloads.doubleIterator = ImmutableShortDoubleHashMapTest::doubleIterator;
            this.payloads.asLazy = ImmutableShortDoubleHashMapTest::asLazy;
            this.payloads.keysView = ImmutableShortDoubleHashMapTest::keysView;
            this.payloads.keyValuesView = ImmutableShortDoubleHashMapTest::keyValuesView;
            this.payloads.toSortedArray = ImmutableShortDoubleHashMapTest::toSortedArray;
            this.payloads.toArray = ImmutableShortDoubleHashMapTest::toArray;
            this.payloads.chunk = ImmutableShortDoubleHashMapTest::chunk;
            this.payloads.testEquals = ImmutableShortDoubleHashMapTest::testEquals;
            this.payloads.keySet = ImmutableShortDoubleHashMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableShortDoubleHashMapTest::flipUniqueValues;
            this.payloads.toImmutable = ImmutableShortDoubleHashMapTest::toImmutable;
            this.payloads.newWithKeyValue = ImmutableShortDoubleHashMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableShortDoubleHashMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableShortDoubleHashMapTest::newWithoutAllKeys;
            this.payloads.injectInto = ImmutableShortDoubleHashMapTest::injectInto;
        }
    }
}
