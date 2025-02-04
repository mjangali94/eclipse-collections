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

import org.eclipse.collections.api.map.primitive.ShortCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortCharMap;
import org.eclipse.collections.impl.factory.primitive.ShortCharMaps;
import org.eclipse.collections.impl.factory.primitive.CharShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortCharHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortCharMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortCharMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableShortCharMapTestCase extends AbstractShortCharMapTestCase {

    @Override
    protected ImmutableShortCharMap classUnderTest() {
        return ShortCharMaps.immutable.withAll(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0, (short) 31, (char) 31, (short) 32, (char) 32));
    }

    @Override
    protected ImmutableShortCharMap newWithKeysValues(short key1, char value1) {
        return ShortCharMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2) {
        return ShortCharMaps.immutable.withAll(new ShortCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3) {
        return ShortCharMaps.immutable.withAll(new ShortCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableShortCharMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3, short key4, char value4) {
        return ShortCharMaps.immutable.withAll(new ShortCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableShortCharMap getEmptyMap() {
        return ShortCharMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        ShortCharMap map1 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1, (short) 32, (char) 32);
        ShortCharMap map2 = this.newWithKeysValues((short) 32, (char) 32, (short) 0, (char) 0, (short) 1, (char) 1);
        ShortCharMap map3 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 2, (short) 32, (char) 32);
        ShortCharMap map4 = this.newWithKeysValues((short) 0, (char) 1, (short) 1, (char) 1, (short) 32, (char) 32);
        ShortCharMap map5 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1, (short) 32, (char) 33);
        ShortCharMap map6 = this.newWithKeysValues((short) 50, (char) 0, (short) 60, (char) 1, (short) 70, (char) 33);
        ShortCharMap map7 = this.newWithKeysValues((short) 50, (char) 0, (short) 60, (char) 1);
        ShortCharMap map8 = this.newWithKeysValues((short) 0, (char) 0, (short) 1, (char) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((char) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(CharShortMaps.immutable.empty(), ShortCharMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableCharShortEmptyMap.class, ShortCharMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(CharShortMaps.immutable.with((char) 2, (short) 1), this.newWithKeysValues((short) 1, (char) 2).flipUniqueValues());
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 2, (short) 1, (char) 3, (short) 2, (char) 4, (short) 3, (char) 5, (short) 4).toImmutable(), this.newWithKeysValues((short) 1, (char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4, (char) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, (char) 1, (short) 2, (char) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableShortCharMapTestCase instance;

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
        public void benchmark_charIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.charIterator);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableShortCharMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableShortCharMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = AbstractImmutableShortCharMapTestCase::values;
            this.payloads.get = AbstractImmutableShortCharMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableShortCharMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractImmutableShortCharMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableShortCharMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableShortCharMapTestCase::containsValue;
            this.payloads.contains = AbstractImmutableShortCharMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableShortCharMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractImmutableShortCharMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractImmutableShortCharMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableShortCharMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableShortCharMapTestCase::notEmpty;
            this.payloads.testHashCode = AbstractImmutableShortCharMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableShortCharMapTestCase::testToString;
            this.payloads.forEach = AbstractImmutableShortCharMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableShortCharMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableShortCharMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableShortCharMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractImmutableShortCharMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractImmutableShortCharMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableShortCharMapTestCase::appendString;
            this.payloads.select = AbstractImmutableShortCharMapTestCase::select;
            this.payloads.reject = AbstractImmutableShortCharMapTestCase::reject;
            this.payloads.select_value = AbstractImmutableShortCharMapTestCase::select_value;
            this.payloads.reject_value = AbstractImmutableShortCharMapTestCase::reject_value;
            this.payloads.collect = AbstractImmutableShortCharMapTestCase::collect;
            this.payloads.count = AbstractImmutableShortCharMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractImmutableShortCharMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractImmutableShortCharMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableShortCharMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableShortCharMapTestCase::noneSatisfy;
            this.payloads.max = AbstractImmutableShortCharMapTestCase::max;
            this.payloads.min = AbstractImmutableShortCharMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortCharMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortCharMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableShortCharMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableShortCharMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableShortCharMapTestCase::sum;
            this.payloads.average = AbstractImmutableShortCharMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortCharMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractImmutableShortCharMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableShortCharMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractImmutableShortCharMapTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableShortCharMapTestCase::toSortedList;
            this.payloads.toSet = AbstractImmutableShortCharMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableShortCharMapTestCase::toBag;
            this.payloads.charIterator = AbstractImmutableShortCharMapTestCase::charIterator;
            this.payloads.asLazy = AbstractImmutableShortCharMapTestCase::asLazy;
            this.payloads.keysView = AbstractImmutableShortCharMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractImmutableShortCharMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractImmutableShortCharMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractImmutableShortCharMapTestCase::toArray;
            this.payloads.toImmutable = AbstractImmutableShortCharMapTestCase::toImmutable;
            this.payloads.chunk = AbstractImmutableShortCharMapTestCase::chunk;
            this.payloads.testEquals = AbstractImmutableShortCharMapTestCase::testEquals;
            this.payloads.keySet = AbstractImmutableShortCharMapTestCase::keySet;
            this.payloads.flipUniqueValues = AbstractImmutableShortCharMapTestCase::flipUniqueValues;
        }
    }
}
