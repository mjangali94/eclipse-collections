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

import org.eclipse.collections.api.map.primitive.ShortIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortIntMap;
import org.eclipse.collections.impl.factory.primitive.ShortIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortIntHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortIntMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortIntMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableShortIntMapTestCase extends AbstractShortIntMapTestCase {

    @Override
    protected ImmutableShortIntMap classUnderTest() {
        return ShortIntMaps.immutable.withAll(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32));
    }

    @Override
    protected ImmutableShortIntMap newWithKeysValues(short key1, int value1) {
        return ShortIntMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2) {
        return ShortIntMaps.immutable.withAll(new ShortIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3) {
        return ShortIntMaps.immutable.withAll(new ShortIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3, short key4, int value4) {
        return ShortIntMaps.immutable.withAll(new ShortIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableShortIntMap getEmptyMap() {
        return ShortIntMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 32, 32);
        ShortIntMap map2 = this.newWithKeysValues((short) 32, 32, (short) 0, 0, (short) 1, 1);
        ShortIntMap map3 = this.newWithKeysValues((short) 0, 0, (short) 1, 2, (short) 32, 32);
        ShortIntMap map4 = this.newWithKeysValues((short) 0, 1, (short) 1, 1, (short) 32, 32);
        ShortIntMap map5 = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 32, 33);
        ShortIntMap map6 = this.newWithKeysValues((short) 50, 0, (short) 60, 1, (short) 70, 33);
        ShortIntMap map7 = this.newWithKeysValues((short) 50, 0, (short) 60, 1);
        ShortIntMap map8 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove((short) 0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove(0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(IntShortMaps.immutable.empty(), ShortIntMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableIntShortEmptyMap.class, ShortIntMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(IntShortMaps.immutable.with(2, (short) 1), this.newWithKeysValues((short) 1, 2).flipUniqueValues());
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(2, (short) 1, 3, (short) 2, 4, (short) 3, 5, (short) 4).toImmutable(), this.newWithKeysValues((short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4, 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, 1, (short) 2, 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableShortIntMapTestCase instance;

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
        public void benchmark_intIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.intIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableShortIntMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> intIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortIntMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = AbstractImmutableShortIntMapTestCase::values;
            this.payloads.get = AbstractImmutableShortIntMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableShortIntMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractImmutableShortIntMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableShortIntMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableShortIntMapTestCase::containsValue;
            this.payloads.contains = AbstractImmutableShortIntMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableShortIntMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractImmutableShortIntMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractImmutableShortIntMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableShortIntMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableShortIntMapTestCase::notEmpty;
            this.payloads.testHashCode = AbstractImmutableShortIntMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableShortIntMapTestCase::testToString;
            this.payloads.forEach = AbstractImmutableShortIntMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableShortIntMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableShortIntMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableShortIntMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractImmutableShortIntMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractImmutableShortIntMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableShortIntMapTestCase::appendString;
            this.payloads.select = AbstractImmutableShortIntMapTestCase::select;
            this.payloads.reject = AbstractImmutableShortIntMapTestCase::reject;
            this.payloads.select_value = AbstractImmutableShortIntMapTestCase::select_value;
            this.payloads.reject_value = AbstractImmutableShortIntMapTestCase::reject_value;
            this.payloads.collect = AbstractImmutableShortIntMapTestCase::collect;
            this.payloads.count = AbstractImmutableShortIntMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractImmutableShortIntMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractImmutableShortIntMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableShortIntMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableShortIntMapTestCase::noneSatisfy;
            this.payloads.max = AbstractImmutableShortIntMapTestCase::max;
            this.payloads.min = AbstractImmutableShortIntMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortIntMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortIntMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableShortIntMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableShortIntMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableShortIntMapTestCase::sum;
            this.payloads.average = AbstractImmutableShortIntMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortIntMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractImmutableShortIntMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortIntMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractImmutableShortIntMapTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableShortIntMapTestCase::toSortedList;
            this.payloads.toSet = AbstractImmutableShortIntMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableShortIntMapTestCase::toBag;
            this.payloads.intIterator = AbstractImmutableShortIntMapTestCase::intIterator;
            this.payloads.asLazy = AbstractImmutableShortIntMapTestCase::asLazy;
            this.payloads.keysView = AbstractImmutableShortIntMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractImmutableShortIntMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractImmutableShortIntMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractImmutableShortIntMapTestCase::toArray;
            this.payloads.toImmutable = AbstractImmutableShortIntMapTestCase::toImmutable;
            this.payloads.chunk = AbstractImmutableShortIntMapTestCase::chunk;
            this.payloads.testEquals = AbstractImmutableShortIntMapTestCase::testEquals;
            this.payloads.keySet = AbstractImmutableShortIntMapTestCase::keySet;
            this.payloads.flipUniqueValues = AbstractImmutableShortIntMapTestCase::flipUniqueValues;
        }
    }
}
