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

import org.eclipse.collections.api.map.primitive.FloatDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatDoubleMap;
import org.eclipse.collections.impl.factory.primitive.FloatDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.DoubleFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatDoubleHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatDoubleMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableFloatDoubleMapTestCase extends AbstractFloatDoubleMapTestCase {

    @Override
    protected ImmutableFloatDoubleMap classUnderTest() {
        return FloatDoubleMaps.immutable.withAll(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0));
    }

    @Override
    protected ImmutableFloatDoubleMap newWithKeysValues(float key1, double value1) {
        return FloatDoubleMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2) {
        return FloatDoubleMaps.immutable.withAll(new FloatDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3) {
        return FloatDoubleMaps.immutable.withAll(new FloatDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3, float key4, double value4) {
        return FloatDoubleMaps.immutable.withAll(new FloatDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableFloatDoubleMap getEmptyMap() {
        return FloatDoubleMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        FloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 32.0f, 32.0);
        FloatDoubleMap map2 = this.newWithKeysValues(32.0f, 32.0, 0.0f, 0.0, 1.0f, 1.0);
        FloatDoubleMap map3 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 2.0, 32.0f, 32.0);
        FloatDoubleMap map4 = this.newWithKeysValues(0.0f, 1.0, 1.0f, 1.0, 32.0f, 32.0);
        FloatDoubleMap map5 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 32.0f, 33.0);
        FloatDoubleMap map6 = this.newWithKeysValues(50.0f, 0.0, 60.0f, 1.0, 70.0f, 33.0);
        FloatDoubleMap map7 = this.newWithKeysValues(50.0f, 0.0, 60.0f, 1.0);
        FloatDoubleMap map8 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove(0.0f));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0.0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(DoubleFloatMaps.immutable.empty(), FloatDoubleMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableDoubleFloatEmptyMap.class, FloatDoubleMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(DoubleFloatMaps.immutable.with(2.0, 1.0f), this.newWithKeysValues(1.0f, 2.0).flipUniqueValues());
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(2.0, 1.0f, 3.0, 2.0f, 4.0, 3.0f, 5.0, 4.0f).toImmutable(), this.newWithKeysValues(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f, 5.0).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, 1.0, 2.0f, 1.0).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableFloatDoubleMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableFloatDoubleMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> doubleIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatDoubleMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = AbstractImmutableFloatDoubleMapTestCase::values;
            this.payloads.get = AbstractImmutableFloatDoubleMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableFloatDoubleMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractImmutableFloatDoubleMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableFloatDoubleMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableFloatDoubleMapTestCase::containsValue;
            this.payloads.contains = AbstractImmutableFloatDoubleMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableFloatDoubleMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractImmutableFloatDoubleMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractImmutableFloatDoubleMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableFloatDoubleMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableFloatDoubleMapTestCase::notEmpty;
            this.payloads.testHashCode = AbstractImmutableFloatDoubleMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableFloatDoubleMapTestCase::testToString;
            this.payloads.forEach = AbstractImmutableFloatDoubleMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableFloatDoubleMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableFloatDoubleMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableFloatDoubleMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractImmutableFloatDoubleMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractImmutableFloatDoubleMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableFloatDoubleMapTestCase::appendString;
            this.payloads.select = AbstractImmutableFloatDoubleMapTestCase::select;
            this.payloads.reject = AbstractImmutableFloatDoubleMapTestCase::reject;
            this.payloads.select_value = AbstractImmutableFloatDoubleMapTestCase::select_value;
            this.payloads.reject_value = AbstractImmutableFloatDoubleMapTestCase::reject_value;
            this.payloads.collect = AbstractImmutableFloatDoubleMapTestCase::collect;
            this.payloads.count = AbstractImmutableFloatDoubleMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractImmutableFloatDoubleMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractImmutableFloatDoubleMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableFloatDoubleMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableFloatDoubleMapTestCase::noneSatisfy;
            this.payloads.max = AbstractImmutableFloatDoubleMapTestCase::max;
            this.payloads.min = AbstractImmutableFloatDoubleMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatDoubleMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatDoubleMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableFloatDoubleMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableFloatDoubleMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableFloatDoubleMapTestCase::sum;
            this.payloads.average = AbstractImmutableFloatDoubleMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatDoubleMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractImmutableFloatDoubleMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatDoubleMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractImmutableFloatDoubleMapTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableFloatDoubleMapTestCase::toSortedList;
            this.payloads.toSet = AbstractImmutableFloatDoubleMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableFloatDoubleMapTestCase::toBag;
            this.payloads.doubleIterator = AbstractImmutableFloatDoubleMapTestCase::doubleIterator;
            this.payloads.asLazy = AbstractImmutableFloatDoubleMapTestCase::asLazy;
            this.payloads.keysView = AbstractImmutableFloatDoubleMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractImmutableFloatDoubleMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractImmutableFloatDoubleMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractImmutableFloatDoubleMapTestCase::toArray;
            this.payloads.toImmutable = AbstractImmutableFloatDoubleMapTestCase::toImmutable;
            this.payloads.chunk = AbstractImmutableFloatDoubleMapTestCase::chunk;
            this.payloads.testEquals = AbstractImmutableFloatDoubleMapTestCase::testEquals;
            this.payloads.keySet = AbstractImmutableFloatDoubleMapTestCase::keySet;
            this.payloads.flipUniqueValues = AbstractImmutableFloatDoubleMapTestCase::flipUniqueValues;
        }
    }
}
