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

import org.eclipse.collections.api.map.primitive.ImmutableObjectDoubleMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMap;
import org.eclipse.collections.impl.math.MutableDouble;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectDoubleHashMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveHashMapTest.stg.
 */
public class ImmutableObjectDoubleHashMapTest extends AbstractImmutableObjectDoubleMapTestCase {

    @Override
    protected ImmutableObjectDoubleMap<String> classUnderTest() {
        return ObjectDoubleHashMap.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0).toImmutable();
    }

    @Test
    public void newWithKeyValue() {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected = ObjectDoubleHashMap.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0, "3", 3.0).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3.0));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue() {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected = this.newWithKeysValues("0", 0.0, "1", 1.0);
        Assert.assertEquals(expected, map1.newWithoutKey("2"));
        Assert.assertNotSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys() {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected = this.newWithKeysValues("1", 1.0);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto() {
        ImmutableObjectDoubleHashMap<String> iterable = new ImmutableObjectDoubleHashMap<>(ObjectDoubleHashMap.newWithKeysValues("3", 3.0, "1", 1.0, "2", 2.0));
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), (MutableDouble object, double value) -> object.add(value));
        Assert.assertEquals(new MutableDouble(6.0), result);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableObjectDoubleHashMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
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
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_throws_emptyList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_throws_emptyList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableObjectDoubleHashMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> newWithoutKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> newWithoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableObjectDoubleHashMapTest> injectInto;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = ImmutableObjectDoubleHashMapTest::values;
            this.payloads.get = ImmutableObjectDoubleHashMapTest::get;
            this.payloads.getOrThrow = ImmutableObjectDoubleHashMapTest::getOrThrow;
            this.payloads.containsKey = ImmutableObjectDoubleHashMapTest::containsKey;
            this.payloads.containsValue = ImmutableObjectDoubleHashMapTest::containsValue;
            this.payloads.size = ImmutableObjectDoubleHashMapTest::size;
            this.payloads.isEmpty = ImmutableObjectDoubleHashMapTest::isEmpty;
            this.payloads.notEmpty = ImmutableObjectDoubleHashMapTest::notEmpty;
            this.payloads.asLazy = ImmutableObjectDoubleHashMapTest::asLazy;
            this.payloads.getIfAbsent = ImmutableObjectDoubleHashMapTest::getIfAbsent;
            this.payloads.testEquals = ImmutableObjectDoubleHashMapTest::testEquals;
            this.payloads.testHashCode = ImmutableObjectDoubleHashMapTest::testHashCode;
            this.payloads.testToString = ImmutableObjectDoubleHashMapTest::testToString;
            this.payloads.doubleIterator = ImmutableObjectDoubleHashMapTest::doubleIterator;
            this.payloads.forEach = ImmutableObjectDoubleHashMapTest::forEach;
            this.payloads.forEachValue = ImmutableObjectDoubleHashMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableObjectDoubleHashMapTest::forEachKey;
            this.payloads.forEachKeyValue = ImmutableObjectDoubleHashMapTest::forEachKeyValue;
            this.payloads.injectIntoKeyValue = ImmutableObjectDoubleHashMapTest::injectIntoKeyValue;
            this.payloads.makeString = ImmutableObjectDoubleHashMapTest::makeString;
            this.payloads.appendString = ImmutableObjectDoubleHashMapTest::appendString;
            this.payloads.select = ImmutableObjectDoubleHashMapTest::select;
            this.payloads.reject = ImmutableObjectDoubleHashMapTest::reject;
            this.payloads.tap = ImmutableObjectDoubleHashMapTest::tap;
            this.payloads.count = ImmutableObjectDoubleHashMapTest::count;
            this.payloads.anySatisfy = ImmutableObjectDoubleHashMapTest::anySatisfy;
            this.payloads.allSatisfy = ImmutableObjectDoubleHashMapTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableObjectDoubleHashMapTest::noneSatisfy;
            this.payloads.detectIfNone = ImmutableObjectDoubleHashMapTest::detectIfNone;
            this.payloads.collect = ImmutableObjectDoubleHashMapTest::collect;
            this.payloads.sum = ImmutableObjectDoubleHashMapTest::sum;
            this.payloads.max = ImmutableObjectDoubleHashMapTest::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectDoubleHashMapTest::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = ImmutableObjectDoubleHashMapTest::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectDoubleHashMapTest::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = ImmutableObjectDoubleHashMapTest::maxIfEmpty;
            this.payloads.minIfEmpty = ImmutableObjectDoubleHashMapTest::minIfEmpty;
            this.payloads.average = ImmutableObjectDoubleHashMapTest::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectDoubleHashMapTest::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = ImmutableObjectDoubleHashMapTest::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableObjectDoubleHashMapTest::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = ImmutableObjectDoubleHashMapTest::toArray;
            this.payloads.toSortedArray = ImmutableObjectDoubleHashMapTest::toSortedArray;
            this.payloads.contains = ImmutableObjectDoubleHashMapTest::contains;
            this.payloads.containsAll = ImmutableObjectDoubleHashMapTest::containsAll;
            this.payloads.containsAll_Iterable = ImmutableObjectDoubleHashMapTest::containsAll_Iterable;
            this.payloads.toList = ImmutableObjectDoubleHashMapTest::toList;
            this.payloads.toSortedList = ImmutableObjectDoubleHashMapTest::toSortedList;
            this.payloads.toSet = ImmutableObjectDoubleHashMapTest::toSet;
            this.payloads.toBag = ImmutableObjectDoubleHashMapTest::toBag;
            this.payloads.toImmutable = ImmutableObjectDoubleHashMapTest::toImmutable;
            this.payloads.keySet = ImmutableObjectDoubleHashMapTest::keySet;
            this.payloads.flipUniqueValues = ImmutableObjectDoubleHashMapTest::flipUniqueValues;
            this.payloads.newWithKeyValue = ImmutableObjectDoubleHashMapTest::newWithKeyValue;
            this.payloads.newWithoutKeyValue = ImmutableObjectDoubleHashMapTest::newWithoutKeyValue;
            this.payloads.newWithoutAllKeys = ImmutableObjectDoubleHashMapTest::newWithoutAllKeys;
            this.payloads.injectInto = ImmutableObjectDoubleHashMapTest::injectInto;
        }
    }
}
