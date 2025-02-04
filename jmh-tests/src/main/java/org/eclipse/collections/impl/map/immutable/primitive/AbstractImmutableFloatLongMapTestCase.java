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

import org.eclipse.collections.api.map.primitive.FloatLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatLongMap;
import org.eclipse.collections.impl.factory.primitive.FloatLongMaps;
import org.eclipse.collections.impl.factory.primitive.LongFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatLongHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatLongMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatLongMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableFloatLongMapTestCase extends AbstractFloatLongMapTestCase {

    @Override
    protected ImmutableFloatLongMap classUnderTest() {
        return FloatLongMaps.immutable.withAll(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 31.0f, 31L, 32.0f, 32L));
    }

    @Override
    protected ImmutableFloatLongMap newWithKeysValues(float key1, long value1) {
        return FloatLongMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2) {
        return FloatLongMaps.immutable.withAll(new FloatLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3) {
        return FloatLongMaps.immutable.withAll(new FloatLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3, float key4, long value4) {
        return FloatLongMaps.immutable.withAll(new FloatLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableFloatLongMap getEmptyMap() {
        return FloatLongMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        FloatLongMap map1 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L, 32.0f, 32L);
        FloatLongMap map2 = this.newWithKeysValues(32.0f, 32L, 0.0f, 0L, 1.0f, 1L);
        FloatLongMap map3 = this.newWithKeysValues(0.0f, 0L, 1.0f, 2L, 32.0f, 32L);
        FloatLongMap map4 = this.newWithKeysValues(0.0f, 1L, 1.0f, 1L, 32.0f, 32L);
        FloatLongMap map5 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L, 32.0f, 33L);
        FloatLongMap map6 = this.newWithKeysValues(50.0f, 0L, 60.0f, 1L, 70.0f, 33L);
        FloatLongMap map7 = this.newWithKeysValues(50.0f, 0L, 60.0f, 1L);
        FloatLongMap map8 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0L));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(LongFloatMaps.immutable.empty(), FloatLongMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableLongFloatEmptyMap.class, FloatLongMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(LongFloatMaps.immutable.with(2L, 1.0f), this.newWithKeysValues(1.0f, 2L).flipUniqueValues());
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(2L, 1.0f, 3L, 2.0f, 4L, 3.0f, 5L, 4.0f).toImmutable(), this.newWithKeysValues(1.0f, 2L, 2.0f, 3L, 3.0f, 4L, 4.0f, 5L).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, 1L, 2.0f, 1L).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableFloatLongMapTestCase instance;

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
        public void benchmark_longIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.longIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableFloatLongMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> longIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableFloatLongMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = AbstractImmutableFloatLongMapTestCase::values;
            this.payloads.get = AbstractImmutableFloatLongMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableFloatLongMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractImmutableFloatLongMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableFloatLongMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableFloatLongMapTestCase::containsValue;
            this.payloads.contains = AbstractImmutableFloatLongMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableFloatLongMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractImmutableFloatLongMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractImmutableFloatLongMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableFloatLongMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableFloatLongMapTestCase::notEmpty;
            this.payloads.testHashCode = AbstractImmutableFloatLongMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableFloatLongMapTestCase::testToString;
            this.payloads.forEach = AbstractImmutableFloatLongMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableFloatLongMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableFloatLongMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableFloatLongMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractImmutableFloatLongMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractImmutableFloatLongMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableFloatLongMapTestCase::appendString;
            this.payloads.select = AbstractImmutableFloatLongMapTestCase::select;
            this.payloads.reject = AbstractImmutableFloatLongMapTestCase::reject;
            this.payloads.select_value = AbstractImmutableFloatLongMapTestCase::select_value;
            this.payloads.reject_value = AbstractImmutableFloatLongMapTestCase::reject_value;
            this.payloads.collect = AbstractImmutableFloatLongMapTestCase::collect;
            this.payloads.count = AbstractImmutableFloatLongMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractImmutableFloatLongMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractImmutableFloatLongMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableFloatLongMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableFloatLongMapTestCase::noneSatisfy;
            this.payloads.max = AbstractImmutableFloatLongMapTestCase::max;
            this.payloads.min = AbstractImmutableFloatLongMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatLongMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatLongMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableFloatLongMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableFloatLongMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableFloatLongMapTestCase::sum;
            this.payloads.average = AbstractImmutableFloatLongMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatLongMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractImmutableFloatLongMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableFloatLongMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractImmutableFloatLongMapTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableFloatLongMapTestCase::toSortedList;
            this.payloads.toSet = AbstractImmutableFloatLongMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableFloatLongMapTestCase::toBag;
            this.payloads.longIterator = AbstractImmutableFloatLongMapTestCase::longIterator;
            this.payloads.asLazy = AbstractImmutableFloatLongMapTestCase::asLazy;
            this.payloads.keysView = AbstractImmutableFloatLongMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractImmutableFloatLongMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractImmutableFloatLongMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractImmutableFloatLongMapTestCase::toArray;
            this.payloads.toImmutable = AbstractImmutableFloatLongMapTestCase::toImmutable;
            this.payloads.chunk = AbstractImmutableFloatLongMapTestCase::chunk;
            this.payloads.testEquals = AbstractImmutableFloatLongMapTestCase::testEquals;
            this.payloads.keySet = AbstractImmutableFloatLongMapTestCase::keySet;
            this.payloads.flipUniqueValues = AbstractImmutableFloatLongMapTestCase::flipUniqueValues;
        }
    }
}
