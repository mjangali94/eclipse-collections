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

import org.eclipse.collections.api.map.primitive.DoubleCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleCharMap;
import org.eclipse.collections.impl.factory.primitive.DoubleCharMaps;
import org.eclipse.collections.impl.factory.primitive.CharDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleCharHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharDoubleHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleCharMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleCharMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableDoubleCharMapTestCase extends AbstractDoubleCharMapTestCase {

    @Override
    protected ImmutableDoubleCharMap classUnderTest() {
        return DoubleCharMaps.immutable.withAll(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0, 31.0, (char) 31, 32.0, (char) 32));
    }

    @Override
    protected ImmutableDoubleCharMap newWithKeysValues(double key1, char value1) {
        return DoubleCharMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableDoubleCharMap newWithKeysValues(double key1, char value1, double key2, char value2) {
        return DoubleCharMaps.immutable.withAll(new DoubleCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableDoubleCharMap newWithKeysValues(double key1, char value1, double key2, char value2, double key3, char value3) {
        return DoubleCharMaps.immutable.withAll(new DoubleCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableDoubleCharMap newWithKeysValues(double key1, char value1, double key2, char value2, double key3, char value3, double key4, char value4) {
        return DoubleCharMaps.immutable.withAll(new DoubleCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableDoubleCharMap getEmptyMap() {
        return DoubleCharMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals() {
        DoubleCharMap map1 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1, 32.0, (char) 32);
        DoubleCharMap map2 = this.newWithKeysValues(32.0, (char) 32, 0.0, (char) 0, 1.0, (char) 1);
        DoubleCharMap map3 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 2, 32.0, (char) 32);
        DoubleCharMap map4 = this.newWithKeysValues(0.0, (char) 1, 1.0, (char) 1, 32.0, (char) 32);
        DoubleCharMap map5 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1, 32.0, (char) 33);
        DoubleCharMap map6 = this.newWithKeysValues(50.0, (char) 0, 60.0, (char) 1, 70.0, (char) 33);
        DoubleCharMap map7 = this.newWithKeysValues(50.0, (char) 0, 60.0, (char) 1);
        DoubleCharMap map8 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1);
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
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().keySet().remove(0.0));
    }

    @Override
    public void values() {
        super.values();
        Assert.assertThrows(UnsupportedOperationException.class, () -> this.classUnderTest().values().remove((char) 0));
    }

    @Test
    public void flipUniqueValues() {
        Assert.assertEquals(CharDoubleMaps.immutable.empty(), DoubleCharMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableCharDoubleEmptyMap.class, DoubleCharMaps.immutable.empty().flipUniqueValues());
        Assert.assertEquals(CharDoubleMaps.immutable.with((char) 2, 1.0), this.newWithKeysValues(1.0, (char) 2).flipUniqueValues());
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 2, 1.0, (char) 3, 2.0, (char) 4, 3.0, (char) 5, 4.0).toImmutable(), this.newWithKeysValues(1.0, (char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0, (char) 5).flipUniqueValues());
        Assert.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, (char) 1, 2.0, (char) 1).flipUniqueValues());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableDoubleCharMapTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableDoubleCharMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> getOrThrow;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> containsAll_Iterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> testHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> injectIntoKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> minIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> maxIfEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> sum;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> average;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> averageThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> median;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> medianThrowsOnEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> charIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> toSortedArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> testEquals;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableDoubleCharMapTestCase> flipUniqueValues;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.values = AbstractImmutableDoubleCharMapTestCase::values;
            this.payloads.get = AbstractImmutableDoubleCharMapTestCase::get;
            this.payloads.getIfAbsent = AbstractImmutableDoubleCharMapTestCase::getIfAbsent;
            this.payloads.getOrThrow = AbstractImmutableDoubleCharMapTestCase::getOrThrow;
            this.payloads.containsKey = AbstractImmutableDoubleCharMapTestCase::containsKey;
            this.payloads.containsValue = AbstractImmutableDoubleCharMapTestCase::containsValue;
            this.payloads.contains = AbstractImmutableDoubleCharMapTestCase::contains;
            this.payloads.containsAll = AbstractImmutableDoubleCharMapTestCase::containsAll;
            this.payloads.containsAll_Iterable = AbstractImmutableDoubleCharMapTestCase::containsAll_Iterable;
            this.payloads.size = AbstractImmutableDoubleCharMapTestCase::size;
            this.payloads.isEmpty = AbstractImmutableDoubleCharMapTestCase::isEmpty;
            this.payloads.notEmpty = AbstractImmutableDoubleCharMapTestCase::notEmpty;
            this.payloads.testHashCode = AbstractImmutableDoubleCharMapTestCase::testHashCode;
            this.payloads.testToString = AbstractImmutableDoubleCharMapTestCase::testToString;
            this.payloads.forEach = AbstractImmutableDoubleCharMapTestCase::forEach;
            this.payloads.forEachValue = AbstractImmutableDoubleCharMapTestCase::forEachValue;
            this.payloads.forEachKey = AbstractImmutableDoubleCharMapTestCase::forEachKey;
            this.payloads.forEachKeyValue = AbstractImmutableDoubleCharMapTestCase::forEachKeyValue;
            this.payloads.injectIntoKeyValue = AbstractImmutableDoubleCharMapTestCase::injectIntoKeyValue;
            this.payloads.makeString = AbstractImmutableDoubleCharMapTestCase::makeString;
            this.payloads.appendString = AbstractImmutableDoubleCharMapTestCase::appendString;
            this.payloads.select = AbstractImmutableDoubleCharMapTestCase::select;
            this.payloads.reject = AbstractImmutableDoubleCharMapTestCase::reject;
            this.payloads.select_value = AbstractImmutableDoubleCharMapTestCase::select_value;
            this.payloads.reject_value = AbstractImmutableDoubleCharMapTestCase::reject_value;
            this.payloads.collect = AbstractImmutableDoubleCharMapTestCase::collect;
            this.payloads.count = AbstractImmutableDoubleCharMapTestCase::count;
            this.payloads.detectIfNone_value = AbstractImmutableDoubleCharMapTestCase::detectIfNone_value;
            this.payloads.anySatisfy = AbstractImmutableDoubleCharMapTestCase::anySatisfy;
            this.payloads.allSatisfy = AbstractImmutableDoubleCharMapTestCase::allSatisfy;
            this.payloads.noneSatisfy = AbstractImmutableDoubleCharMapTestCase::noneSatisfy;
            this.payloads.max = AbstractImmutableDoubleCharMapTestCase::max;
            this.payloads.min = AbstractImmutableDoubleCharMapTestCase::min;
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleCharMapTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleCharMapTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.minIfEmpty = AbstractImmutableDoubleCharMapTestCase::minIfEmpty;
            this.payloads.maxIfEmpty = AbstractImmutableDoubleCharMapTestCase::maxIfEmpty;
            this.payloads.sum = AbstractImmutableDoubleCharMapTestCase::sum;
            this.payloads.average = AbstractImmutableDoubleCharMapTestCase::average;
            this.payloads.averageThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleCharMapTestCase::averageThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.median = AbstractImmutableDoubleCharMapTestCase::median;
            this.payloads.medianThrowsOnEmpty = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableDoubleCharMapTestCase::medianThrowsOnEmpty, java.lang.ArithmeticException.class);
            this.payloads.toList = AbstractImmutableDoubleCharMapTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableDoubleCharMapTestCase::toSortedList;
            this.payloads.toSet = AbstractImmutableDoubleCharMapTestCase::toSet;
            this.payloads.toBag = AbstractImmutableDoubleCharMapTestCase::toBag;
            this.payloads.charIterator = AbstractImmutableDoubleCharMapTestCase::charIterator;
            this.payloads.asLazy = AbstractImmutableDoubleCharMapTestCase::asLazy;
            this.payloads.keysView = AbstractImmutableDoubleCharMapTestCase::keysView;
            this.payloads.keyValuesView = AbstractImmutableDoubleCharMapTestCase::keyValuesView;
            this.payloads.toSortedArray = AbstractImmutableDoubleCharMapTestCase::toSortedArray;
            this.payloads.toArray = AbstractImmutableDoubleCharMapTestCase::toArray;
            this.payloads.toImmutable = AbstractImmutableDoubleCharMapTestCase::toImmutable;
            this.payloads.chunk = AbstractImmutableDoubleCharMapTestCase::chunk;
            this.payloads.testEquals = AbstractImmutableDoubleCharMapTestCase::testEquals;
            this.payloads.keySet = AbstractImmutableDoubleCharMapTestCase::keySet;
            this.payloads.flipUniqueValues = AbstractImmutableDoubleCharMapTestCase::flipUniqueValues;
        }
    }
}
