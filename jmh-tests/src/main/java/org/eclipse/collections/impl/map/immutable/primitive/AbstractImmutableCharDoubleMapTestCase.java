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

import org.eclipse.collections.api.map.primitive.CharDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharDoubleMap;
import org.eclipse.collections.impl.factory.primitive.CharDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.DoubleCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharDoubleHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharDoubleMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableCharDoubleMapTestCase extends AbstractCharDoubleMapTestCase {

    @Override
    protected ImmutableCharDoubleMap classUnderTest() {
        return CharDoubleMaps.immutable.withAll(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0));
    }

    @Override
    protected ImmutableCharDoubleMap newWithKeysValues(char key1, double value1) {
        return CharDoubleMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2) {
        return CharDoubleMaps.immutable.withAll(new CharDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3) {
        return CharDoubleMaps.immutable.withAll(new CharDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3, char key4, double value4) {
        return CharDoubleMaps.immutable.withAll(new CharDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableCharDoubleMap getEmptyMap() {
        return CharDoubleMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        CharDoubleMap map1 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 32, 32.0);
        CharDoubleMap map2 = this.newWithKeysValues((char) 32, 32.0, (char) 0, 0.0, (char) 1, 1.0);
        CharDoubleMap map3 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 2.0, (char) 32, 32.0);
        CharDoubleMap map4 = this.newWithKeysValues((char) 0, 1.0, (char) 1, 1.0, (char) 32, 32.0);
        CharDoubleMap map5 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 32, 33.0);
        CharDoubleMap map6 = this.newWithKeysValues((char) 50, 0.0, (char) 60, 1.0, (char) 70, 33.0);
        CharDoubleMap map7 = this.newWithKeysValues((char) 50, 0.0, (char) 60, 1.0);
        CharDoubleMap map8 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedIdentity(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
    }

    @Override
    @Test
    public void keySet() {
        super.keySet();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove((char) 0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(DoubleCharMaps.immutable.empty(), CharDoubleMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableDoubleCharEmptyMap.class, CharDoubleMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(DoubleCharMaps.immutable.with(2.0, (char) 1), this.newWithKeysValues((char) 1, 2.0).flipUniqueValues());
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(2.0, (char) 1, 3.0, (char) 2, 4.0, (char) 3, 5.0, (char) 4).toImmutable(), this.newWithKeysValues((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4, 5.0).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, 1.0, (char) 2, 1.0).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableCharDoubleMapTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
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
        public void benchmark_testHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
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
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxIfEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxIfEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sum() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sum);
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
        public void benchmark_doubleIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.doubleIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEquals() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEquals);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableCharDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableCharDoubleMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = AbstractImmutableCharDoubleMapTestCase::values;
            this.payloads.get = AbstractImmutableCharDoubleMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableCharDoubleMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractImmutableCharDoubleMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableCharDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableCharDoubleMapTestCase::containsValue;
            this.payloads.contains = AbstractImmutableCharDoubleMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableCharDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractImmutableCharDoubleMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractImmutableCharDoubleMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableCharDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableCharDoubleMapTestCase::notEmpty;
            this.payloads.testHashCode = AbstractImmutableCharDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableCharDoubleMapTestCase::testToString;
            this.payloads.forEach = AbstractImmutableCharDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableCharDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableCharDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableCharDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractImmutableCharDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractImmutableCharDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableCharDoubleMapTestCase::appendString;
            this.payloads.select = AbstractImmutableCharDoubleMapTestCase::select;
            this.payloads.reject = AbstractImmutableCharDoubleMapTestCase::reject;
            this.payloads.select_value = AbstractImmutableCharDoubleMapTestCase::select_value;
            this.payloads.reject_value = AbstractImmutableCharDoubleMapTestCase::reject_value;
            this.payloads.collect = AbstractImmutableCharDoubleMapTestCase::collect;
            this.payloads.count = AbstractImmutableCharDoubleMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractImmutableCharDoubleMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractImmutableCharDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableCharDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableCharDoubleMapTestCase::noneSatisfy;
            this.payloads.max = AbstractImmutableCharDoubleMapTestCase::max;
            this.payloads.min = AbstractImmutableCharDoubleMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharDoubleMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharDoubleMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableCharDoubleMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableCharDoubleMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableCharDoubleMapTestCase::sum;
            this.payloads.average = AbstractImmutableCharDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractImmutableCharDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableCharDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractImmutableCharDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableCharDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractImmutableCharDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableCharDoubleMapTestCase::toBag;
            this.payloads.doubleIterator = AbstractImmutableCharDoubleMapTestCase::doubleIterator;
            this.payloads.asLazy = AbstractImmutableCharDoubleMapTestCase::asLazy;
            this.payloads.keysView = AbstractImmutableCharDoubleMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractImmutableCharDoubleMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractImmutableCharDoubleMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractImmutableCharDoubleMapTestCase::toArray;
            this.payloads.toImmutable = AbstractImmutableCharDoubleMapTestCase::toImmutable;
            this.payloads.chunk = AbstractImmutableCharDoubleMapTestCase::chunk;
            this.payloads.testEquals = AbstractImmutableCharDoubleMapTestCase::testEquals;
            this.payloads.keySet = AbstractImmutableCharDoubleMapTestCase::keySet;
            this.payloads.flipUniqueValues = AbstractImmutableCharDoubleMapTestCase::flipUniqueValues;
        }
    }
}
