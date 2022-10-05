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

import org.eclipse.collections.api.map.primitive.ImmutableObjectFloatMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMap;
import org.eclipse.collections.impl.math.MutableFloat;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectFloatHashMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveHashMapTest.stg.
 */
public class ImmutableObjectFloatHashMapTest extends AbstractImmutableObjectFloatMapTestCase {

    @Override
    protected ImmutableObjectFloatMap<String> classUnderTest() {
        return ObjectFloatHashMap.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f).toImmutable();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected = ObjectFloatHashMap.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f, "3", 3.0f).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3.0f));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected = this.newWithKeysValues("0", 0.0f, "1", 1.0f);
        Assert.assertEquals(expected, map1.newWithoutKey("2"));
        Assert.assertNotSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected = this.newWithKeysValues("1", 1.0f);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto() {
        ImmutableObjectFloatHashMap<String> iterable = new ImmutableObjectFloatHashMap<>(ObjectFloatHashMap.newWithKeysValues("3", 3.0f, "1", 1.0f, "2", 2.0f));
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), (MutableFloat object, float value) -> object.add(value));
        Assert.assertEquals(new MutableFloat(6.0f), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableObjectFloatHashMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrThrow() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrThrow);
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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
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
        public void benchmark_floatIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.floatIterator);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutAllKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableObjectFloatHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> floatIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectFloatHashMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableObjectFloatHashMapTest::values;
            this.payloads.get = ImmutableObjectFloatHashMapTest::get;
            this.payloads.getOrThrow = ImmutableObjectFloatHashMapTest::getOrThrow;
            this.payloads.containsKey = ImmutableObjectFloatHashMapTest::containsKey;
            this.payloads.containsValue = ImmutableObjectFloatHashMapTest::containsValue;
            this.payloads.size = ImmutableObjectFloatHashMapTest::size;
            this.payloads.isEmpty = ImmutableObjectFloatHashMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableObjectFloatHashMapTest::notEmpty;
            this.payloads.asLazy = ImmutableObjectFloatHashMapTest::asLazy;
            this.payloads.getIfAbsent = ImmutableObjectFloatHashMapTest::getIfAbsent;
            this.payloads.testEquals = ImmutableObjectFloatHashMapTest::testEquals;
            this.payloads.testHashCode = ImmutableObjectFloatHashMapTest::testHashCode;
            this.payloads.testToString = ImmutableObjectFloatHashMapTest::testToString;
            this.payloads.floatIterator = ImmutableObjectFloatHashMapTest::floatIterator;
            this.payloads.forEach = ImmutableObjectFloatHashMapTest::forEach;
            this.payloads.forEachValue = ImmutableObjectFloatHashMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableObjectFloatHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableObjectFloatHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableObjectFloatHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableObjectFloatHashMapTest::makeString;
            this.payloads.appendString = ImmutableObjectFloatHashMapTest::appendString;
            this.payloads.select = ImmutableObjectFloatHashMapTest::select;
            this.payloads.reject = ImmutableObjectFloatHashMapTest::reject;
            this.payloads.tap = ImmutableObjectFloatHashMapTest::tap;
            this.payloads.count = ImmutableObjectFloatHashMapTest::count;
            this.payloads.anySatisfy = ImmutableObjectFloatHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableObjectFloatHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableObjectFloatHashMapTest::noneSatisfy;
            this.payloads.detectIfNone = ImmutableObjectFloatHashMapTest::detectIfNone;
            this.payloads.collect = ImmutableObjectFloatHashMapTest::collect;
            this.payloads.sum = ImmutableObjectFloatHashMapTest::sum;
            this.payloads.max = ImmutableObjectFloatHashMapTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectFloatHashMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableObjectFloatHashMapTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectFloatHashMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ImmutableObjectFloatHashMapTest::maxIfEmpty;
            this.payloads.minIfEmpty = ImmutableObjectFloatHashMapTest::minIfEmpty;
            this.payloads.average = ImmutableObjectFloatHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectFloatHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableObjectFloatHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectFloatHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableObjectFloatHashMapTest::toArray;
            this.payloads.toSortedArray = ImmutableObjectFloatHashMapTest::toSortedArray;
            this.payloads.contains = ImmutableObjectFloatHashMapTest::contains;
            this.payloads.containsAll = ImmutableObjectFloatHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ImmutableObjectFloatHashMapTest::containsAll_Iterable;
            this.payloads.toList = ImmutableObjectFloatHashMapTest::toList;
            this.payloads.toSortedList = ImmutableObjectFloatHashMapTest::toSortedList;
            this.payloads.toSet = ImmutableObjectFloatHashMapTest::toSet;
            this.payloads.toBag = ImmutableObjectFloatHashMapTest::toBag;
            this.payloads.toImmutable = ImmutableObjectFloatHashMapTest::toImmutable;
            this.payloads.keySet = ImmutableObjectFloatHashMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableObjectFloatHashMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableObjectFloatHashMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableObjectFloatHashMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableObjectFloatHashMapTest::newWithoutAllKeys;
            this.payloads.injectInto = ImmutableObjectFloatHashMapTest::injectInto;
        }
    }
}
