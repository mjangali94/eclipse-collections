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

import org.eclipse.collections.api.map.primitive.ImmutableCharShortMap;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.CharShortHashMap;
import org.eclipse.collections.impl.math.MutableShort;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharShortHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableCharShortHashMapTest extends AbstractImmutableCharShortMapTestCase {

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableCharShortMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue() {
        ImmutableCharShortMap map1 = this.classUnderTest();
        ImmutableCharShortMap expected = this.newWithKeysValues((char) 0, (short) 0, (char) 31, (short) 31, (char) 32, (short) 32, (char) 33, (short) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 33, (short) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 33, (short) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableCharShortMap map1 = this.classUnderTest();
        ImmutableCharShortMap expected = this.newWithKeysValues((char) 0, (short) 0, (char) 31, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutKey((char) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableCharShortMap map1 = this.classUnderTest();
        ImmutableCharShortMap expected = this.newWithKeysValues((char) 31, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto() {
        ImmutableCharShortHashMap iterable = new ImmutableCharShortHashMap(CharShortHashMap.newWithKeysValues((char) 1, (short) 1, (char) 2, (short) 2, (char) 3, (short) 3));
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableCharShortHashMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableCharShortHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> shortIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableCharShortHashMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableCharShortHashMapTest::values;
            this.payloads.get = ImmutableCharShortHashMapTest::get;
            this.payloads.getIfAbsent = ImmutableCharShortHashMapTest::getIfAbsent;
            this.payloads.getOrThrow = ImmutableCharShortHashMapTest::getOrThrow;
            this.payloads.containsKey = ImmutableCharShortHashMapTest::containsKey;
            this.payloads.containsValue = ImmutableCharShortHashMapTest::containsValue;
            this.payloads.contains = ImmutableCharShortHashMapTest::contains;
            this.payloads.containsAll = ImmutableCharShortHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ImmutableCharShortHashMapTest::containsAll_Iterable;
            this.payloads.size = ImmutableCharShortHashMapTest::size;
            this.payloads.isEmpty = ImmutableCharShortHashMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableCharShortHashMapTest::notEmpty;
            this.payloads.testHashCode = ImmutableCharShortHashMapTest::testHashCode;
            this.payloads.testToString = ImmutableCharShortHashMapTest::testToString;
            this.payloads.forEach = ImmutableCharShortHashMapTest::forEach;
            this.payloads.forEachValue = ImmutableCharShortHashMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableCharShortHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableCharShortHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableCharShortHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableCharShortHashMapTest::makeString;
            this.payloads.appendString = ImmutableCharShortHashMapTest::appendString;
            this.payloads.select = ImmutableCharShortHashMapTest::select;
            this.payloads.reject = ImmutableCharShortHashMapTest::reject;
            this.payloads.select_value = ImmutableCharShortHashMapTest::select_value;
            this.payloads.reject_value = ImmutableCharShortHashMapTest::reject_value;
            this.payloads.collect = ImmutableCharShortHashMapTest::collect;
            this.payloads.count = ImmutableCharShortHashMapTest::count;
            this.payloads.detectIfNone_value = ImmutableCharShortHashMapTest::detectIfNone_value;
            this.payloads.anySatisfy = ImmutableCharShortHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableCharShortHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableCharShortHashMapTest::noneSatisfy;
            this.payloads.max = ImmutableCharShortHashMapTest::max;
            this.payloads.min = ImmutableCharShortHashMapTest::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharShortHashMapTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharShortHashMapTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = ImmutableCharShortHashMapTest::minIfEmpty;
            this.payloads.maxIfEmpty = ImmutableCharShortHashMapTest::maxIfEmpty;
            this.payloads.sum = ImmutableCharShortHashMapTest::sum;
            this.payloads.average = ImmutableCharShortHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharShortHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableCharShortHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableCharShortHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = ImmutableCharShortHashMapTest::toList;
            this.payloads.toSortedList = ImmutableCharShortHashMapTest::toSortedList;
            this.payloads.toSet = ImmutableCharShortHashMapTest::toSet;
            this.payloads.toBag = ImmutableCharShortHashMapTest::toBag;
            this.payloads.shortIterator = ImmutableCharShortHashMapTest::shortIterator;
            this.payloads.asLazy = ImmutableCharShortHashMapTest::asLazy;
            this.payloads.keysView = ImmutableCharShortHashMapTest::keysView;
            this.payloads.keyValuesView = ImmutableCharShortHashMapTest::keyValuesView;
            this.payloads.toSortedArray = ImmutableCharShortHashMapTest::toSortedArray;
            this.payloads.toArray = ImmutableCharShortHashMapTest::toArray;
            this.payloads.chunk = ImmutableCharShortHashMapTest::chunk;
            this.payloads.testEquals = ImmutableCharShortHashMapTest::testEquals;
            this.payloads.keySet = ImmutableCharShortHashMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableCharShortHashMapTest::flipUniqueValues;
            this.payloads.toImmutable = ImmutableCharShortHashMapTest::toImmutable;
            this.payloads.newWithKeyValue = ImmutableCharShortHashMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableCharShortHashMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableCharShortHashMapTest::newWithoutAllKeys;
            this.payloads.injectInto = ImmutableCharShortHashMapTest::injectInto;
        }
    }
}
