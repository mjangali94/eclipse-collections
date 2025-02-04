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

import org.eclipse.collections.api.map.primitive.ImmutableCharIntMap;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.CharIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharIntHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableCharIntHashMapTest extends AbstractImmutableCharIntMapTestCase {

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableCharIntMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue() {
        ImmutableCharIntMap map1 = this.classUnderTest();
        ImmutableCharIntMap expected = this.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32, (char) 33, 33);
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 33, 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 33, 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableCharIntMap map1 = this.classUnderTest();
        ImmutableCharIntMap expected = this.newWithKeysValues((char) 0, 0, (char) 31, 31);
        Assert.assertEquals(expected, map1.newWithoutKey((char) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableCharIntMap map1 = this.classUnderTest();
        ImmutableCharIntMap expected = this.newWithKeysValues((char) 31, 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto() {
        ImmutableCharIntHashMap iterable = new ImmutableCharIntHashMap(CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3));
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(6), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableCharIntHashMapTest instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableCharIntHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharIntHashMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableCharIntHashMapTest::values;
            this.payloads.get = ImmutableCharIntHashMapTest::get;
            this.payloads.getIfAbsent = ImmutableCharIntHashMapTest::getIfAbsent;
            this.payloads.getOrThrow = ImmutableCharIntHashMapTest::getOrThrow;
            this.payloads.containsKey = ImmutableCharIntHashMapTest::containsKey;
            this.payloads.containsValue = ImmutableCharIntHashMapTest::containsValue;
            this.payloads.contains = ImmutableCharIntHashMapTest::contains;
            this.payloads.containsAll = ImmutableCharIntHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ImmutableCharIntHashMapTest::containsAll_Iterable;
            this.payloads.size = ImmutableCharIntHashMapTest::size;
            this.payloads.isEmpty = ImmutableCharIntHashMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableCharIntHashMapTest::notEmpty;
            this.payloads.testHashCode = ImmutableCharIntHashMapTest::testHashCode;
            this.payloads.testToString = ImmutableCharIntHashMapTest::testToString;
            this.payloads.forEach = ImmutableCharIntHashMapTest::forEach;
            this.payloads.forEachValue = ImmutableCharIntHashMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableCharIntHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableCharIntHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableCharIntHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableCharIntHashMapTest::makeString;
            this.payloads.appendString = ImmutableCharIntHashMapTest::appendString;
            this.payloads.select = ImmutableCharIntHashMapTest::select;
            this.payloads.reject = ImmutableCharIntHashMapTest::reject;
            this.payloads.select_value = ImmutableCharIntHashMapTest::select_value;
            this.payloads.reject_value = ImmutableCharIntHashMapTest::reject_value;
            this.payloads.collect = ImmutableCharIntHashMapTest::collect;
            this.payloads.count = ImmutableCharIntHashMapTest::count;
            this.payloads.detectIfNone_value = ImmutableCharIntHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableCharIntHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableCharIntHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableCharIntHashMapTest::noneSatisfy;
            this.payloads.max = ImmutableCharIntHashMapTest::max;
            this.payloads.min = ImmutableCharIntHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharIntHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharIntHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableCharIntHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableCharIntHashMapTest::maxIfEmpty;
            this.payloads.sum = ImmutableCharIntHashMapTest::sum;
            this.payloads.average = ImmutableCharIntHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharIntHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableCharIntHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharIntHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableCharIntHashMapTest::toList;
            this.payloads.toSortedList = ImmutableCharIntHashMapTest::toSortedList;
            this.payloads.toSet = ImmutableCharIntHashMapTest::toSet;
            this.payloads.toBag = ImmutableCharIntHashMapTest::toBag;
            this.payloads.intIterator = ImmutableCharIntHashMapTest::intIterator;
            this.payloads.asLazy = ImmutableCharIntHashMapTest::asLazy;
            this.payloads.keysView = ImmutableCharIntHashMapTest::keysView;
            this.payloads.keyValuesView = ImmutableCharIntHashMapTest::keyValuesView;
            this.payloads.toSortedArray = ImmutableCharIntHashMapTest::toSortedArray;
            this.payloads.toArray = ImmutableCharIntHashMapTest::toArray;
            this.payloads.chunk = ImmutableCharIntHashMapTest::chunk;
            this.payloads.testEquals = ImmutableCharIntHashMapTest::testEquals;
            this.payloads.keySet = ImmutableCharIntHashMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableCharIntHashMapTest::flipUniqueValues;
            this.payloads.toImmutable = ImmutableCharIntHashMapTest::toImmutable;
            this.payloads.newWithKeyValue = ImmutableCharIntHashMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableCharIntHashMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableCharIntHashMapTest::newWithoutAllKeys;
            this.payloads.injectInto = ImmutableCharIntHashMapTest::injectInto;
        }
    }
}
