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
import org.eclipse.collections.impl.factory.primitive.DoubleObjectMaps;
import org.eclipse.collections.impl.factory.primitive.ObjectDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleObjectHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableObjectDoubleHashMap}.
 * This file was automatically generated from template file abstractImmutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableObjectDoubleMapTestCase extends AbstractObjectDoubleMapTestCase {

    @Override
    protected abstract ImmutableObjectDoubleMap<String> classUnderTest();

    @Override
    protected <T> ImmutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3, T key4, double value4) {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectDoubleMap<T> getEmptyMap() {
        return new ObjectDoubleHashMap<T>().toImmutable();
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableObjectDoubleMap<String> map = this.classUnderTest();
        Assert.assertSame(map, map.toImmutable());
    }

    @Override
    @Test
    public void keySet() {
        super.keySet();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove("0"));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(DoubleObjectMaps.immutable.empty(), ObjectDoubleMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableDoubleObjectEmptyMap.class, ObjectDoubleMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(DoubleObjectMaps.immutable.with(2.0, "1"), this.newWithKeysValues("1", 2.0).flipUniqueValues());
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(2.0, "1", 3.0, "2").toImmutable(), this.newWithKeysValues("1", 2.0, "2", 3.0).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues("1", 1.0, "2", 1.0).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableObjectDoubleMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableObjectDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectDoubleMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = AbstractImmutableObjectDoubleMapTestCase::values;
            this.payloads.get = AbstractImmutableObjectDoubleMapTestCase::get;
            this.payloads.getOrThrow = AbstractImmutableObjectDoubleMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableObjectDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableObjectDoubleMapTestCase::containsValue;
            this.payloads.size = AbstractImmutableObjectDoubleMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableObjectDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableObjectDoubleMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractImmutableObjectDoubleMapTestCase::asLazy;
            this.payloads.getIfAbsent = AbstractImmutableObjectDoubleMapTestCase::getIfAbsent;
            this.payloads.testEquals = AbstractImmutableObjectDoubleMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableObjectDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableObjectDoubleMapTestCase::testToString;
            this.payloads.doubleIterator = AbstractImmutableObjectDoubleMapTestCase::doubleIterator;
            this.payloads.forEach = AbstractImmutableObjectDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableObjectDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableObjectDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableObjectDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractImmutableObjectDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractImmutableObjectDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableObjectDoubleMapTestCase::appendString;
            this.payloads.select = AbstractImmutableObjectDoubleMapTestCase::select;
            this.payloads.reject = AbstractImmutableObjectDoubleMapTestCase::reject;
            this.payloads.tap = AbstractImmutableObjectDoubleMapTestCase::tap;
            this.payloads.count = AbstractImmutableObjectDoubleMapTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableObjectDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableObjectDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableObjectDoubleMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractImmutableObjectDoubleMapTestCase::detectIfNone;
            this.payloads.collect = AbstractImmutableObjectDoubleMapTestCase::collect;
            this.payloads.sum = AbstractImmutableObjectDoubleMapTestCase::sum;
            this.payloads.max = AbstractImmutableObjectDoubleMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableObjectDoubleMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableObjectDoubleMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableObjectDoubleMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractImmutableObjectDoubleMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractImmutableObjectDoubleMapTestCase::minIfEmpty;
            this.payloads.average = AbstractImmutableObjectDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableObjectDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractImmutableObjectDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableObjectDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractImmutableObjectDoubleMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractImmutableObjectDoubleMapTestCase::toSortedArray;
            this.payloads.contains = AbstractImmutableObjectDoubleMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableObjectDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractImmutableObjectDoubleMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractImmutableObjectDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableObjectDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractImmutableObjectDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableObjectDoubleMapTestCase::toBag;
            this.payloads.toImmutable = AbstractImmutableObjectDoubleMapTestCase::toImmutable;
            this.payloads.keySet = AbstractImmutableObjectDoubleMapTestCase::keySet;
            this.payloads.flipUniqueValues = AbstractImmutableObjectDoubleMapTestCase::flipUniqueValues;
        }
    }
}
