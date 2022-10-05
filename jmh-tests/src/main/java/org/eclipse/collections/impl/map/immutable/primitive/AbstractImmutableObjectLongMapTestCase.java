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

import org.eclipse.collections.api.map.primitive.ImmutableObjectLongMap;
import org.eclipse.collections.impl.factory.primitive.LongObjectMaps;
import org.eclipse.collections.impl.factory.primitive.ObjectLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectLongMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableObjectLongHashMap}.
 * This file was automatically generated from template file abstractImmutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableObjectLongMapTestCase extends AbstractObjectLongMapTestCase {

    @Override
    protected abstract ImmutableObjectLongMap<String> classUnderTest();

    @Override
    protected <T> ImmutableObjectLongMap<T> newWithKeysValues(T key1, long value1) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3, T key4, long value4) {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4).toImmutable();
    }

    @Override
    protected <T> ImmutableObjectLongMap<T> getEmptyMap() {
        return new ObjectLongHashMap<T>().toImmutable();
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        ImmutableObjectLongMap<String> map = this.classUnderTest();
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0L));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(LongObjectMaps.immutable.empty(), ObjectLongMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableLongObjectEmptyMap.class, ObjectLongMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(LongObjectMaps.immutable.with(2L, "1"), this.newWithKeysValues("1", 2L).flipUniqueValues());
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(2L, "1", 3L, "2").toImmutable(), this.newWithKeysValues("1", 2L, "2", 3L).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues("1", 1L, "2", 1L).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableObjectLongMapTestCase instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableObjectLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> max_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> min_throws_emptyList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableObjectLongMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = AbstractImmutableObjectLongMapTestCase::values;
            this.payloads.get = AbstractImmutableObjectLongMapTestCase::get;
            this.payloads.getOrThrow = AbstractImmutableObjectLongMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableObjectLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableObjectLongMapTestCase::containsValue;
            this.payloads.size = AbstractImmutableObjectLongMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableObjectLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableObjectLongMapTestCase::notEmpty;
            this.payloads.asLazy = AbstractImmutableObjectLongMapTestCase::asLazy;
            this.payloads.getIfAbsent = AbstractImmutableObjectLongMapTestCase::getIfAbsent;
            this.payloads.testEquals = AbstractImmutableObjectLongMapTestCase::testEquals;
            this.payloads.testHashCode = AbstractImmutableObjectLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableObjectLongMapTestCase::testToString;
            this.payloads.longIterator = AbstractImmutableObjectLongMapTestCase::longIterator;
            this.payloads.forEach = AbstractImmutableObjectLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableObjectLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableObjectLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableObjectLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractImmutableObjectLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractImmutableObjectLongMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableObjectLongMapTestCase::appendString;
            this.payloads.select = AbstractImmutableObjectLongMapTestCase::select;
            this.payloads.reject = AbstractImmutableObjectLongMapTestCase::reject;
            this.payloads.tap = AbstractImmutableObjectLongMapTestCase::tap;
            this.payloads.count = AbstractImmutableObjectLongMapTestCase::count;
            this.payloads.anySatisfy = AbstractImmutableObjectLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableObjectLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableObjectLongMapTestCase::noneSatisfy;
            this.payloads.detectIfNone = AbstractImmutableObjectLongMapTestCase::detectIfNone;
            this.payloads.collect = AbstractImmutableObjectLongMapTestCase::collect;
            this.payloads.sum = AbstractImmutableObjectLongMapTestCase::sum;
            this.payloads.max = AbstractImmutableObjectLongMapTestCase::max;
            this.payloads.max_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableObjectLongMapTestCase::max_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractImmutableObjectLongMapTestCase::min;
            this.payloads.min_throws_emptyList = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableObjectLongMapTestCase::min_throws_emptyList, java.util.NoSuchElementException.class);
            this.payloads.maxIfEmpty = AbstractImmutableObjectLongMapTestCase::maxIfEmpty;
            this.payloads.minIfEmpty = AbstractImmutableObjectLongMapTestCase::minIfEmpty;
            this.payloads.average = AbstractImmutableObjectLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableObjectLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractImmutableObjectLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableObjectLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toArray = AbstractImmutableObjectLongMapTestCase::toArray;
            this.payloads.toSortedArray = AbstractImmutableObjectLongMapTestCase::toSortedArray;
            this.payloads.contains = AbstractImmutableObjectLongMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableObjectLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractImmutableObjectLongMapTestCase::containsAll_Iterable;
            this.payloads.toList = AbstractImmutableObjectLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableObjectLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractImmutableObjectLongMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableObjectLongMapTestCase::toBag;
            this.payloads.toImmutable = AbstractImmutableObjectLongMapTestCase::toImmutable;
            this.payloads.keySet = AbstractImmutableObjectLongMapTestCase::keySet;
            this.payloads.flipUniqueValues = AbstractImmutableObjectLongMapTestCase::flipUniqueValues;
        }
    }
}
