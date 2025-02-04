/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.immutable;

import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.parallel.BatchIterable;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableUnifiedMapTest extends ImmutableMapTestCase {

    @Override
    protected ImmutableMap<Integer, String> classUnderTest() {
        return new ImmutableUnifiedMap<>(Tuples.pair(1, "1"), Tuples.pair(2, "2"), Tuples.pair(3, "3"), Tuples.pair(4, "4"));
    }

    @Override
    protected int size() {
        return 4;
    }

    @Test
    @Override
    public void testToString() {
        Assert.assertEquals("{1=1, 2=2, 3=3, 4=4}", this.classUnderTest().toString());
    }

    @Test
    public void getBatchCount() {
        BatchIterable<Integer> integerBatchIterable = (BatchIterable<Integer>) this.classUnderTest();
        Assert.assertEquals(5, integerBatchIterable.getBatchCount(3));
    }

    @Test
    public void batchForEach() {
        Sum sum = new IntegerSum(0);
        BatchIterable<String> integerBatchIterable = (BatchIterable<String>) this.classUnderTest();
        integerBatchIterable.batchForEach(each -> sum.add(Integer.valueOf(each)), 0, 1);
        Assert.assertEquals(10, sum.getValue());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableUnifiedMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorThrows);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent_function);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrDefault);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMap1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMap1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapIterableTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmptyAndTargetEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableNull);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAllKeyValuePairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAllKeyValuePairs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAllKeyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.castToMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getBatchCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getBatchCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEach);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableUnifiedMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> castToMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> getBatchCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapTest> batchForEach;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.equalsAndHashCode = ImmutableUnifiedMapTest::equalsAndHashCode;
            this.payloads.forEachKeyValue = ImmutableUnifiedMapTest::forEachKeyValue;
            this.payloads.forEachValue = ImmutableUnifiedMapTest::forEachValue;
            this.payloads.tap = ImmutableUnifiedMapTest::tap;
            this.payloads.forEach = ImmutableUnifiedMapTest::forEach;
            this.payloads.flipUniqueValues = ImmutableUnifiedMapTest::flipUniqueValues;
            this.payloads.iterator = ImmutableUnifiedMapTest::iterator;
            this.payloads.iteratorThrows = ImmutableUnifiedMapTest::iteratorThrows;
            this.payloads.forEachKey = ImmutableUnifiedMapTest::forEachKey;
            this.payloads.get = ImmutableUnifiedMapTest::get;
            this.payloads.getIfAbsent_function = ImmutableUnifiedMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableUnifiedMapTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableUnifiedMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableUnifiedMapTest::getIfAbsentWith;
            this.payloads.ifPresentApply = ImmutableUnifiedMapTest::ifPresentApply;
            this.payloads.notEmpty = ImmutableUnifiedMapTest::notEmpty;
            this.payloads.forEachWith = ImmutableUnifiedMapTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableUnifiedMapTest::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableUnifiedMapTest::keyValuesView;
            this.payloads.valuesView = ImmutableUnifiedMapTest::valuesView;
            this.payloads.keysView = ImmutableUnifiedMapTest::keysView;
            this.payloads.putAll = ImmutableUnifiedMapTest::putAll;
            this.payloads.clear = ImmutableUnifiedMapTest::clear;
            this.payloads.put = ImmutableUnifiedMapTest::put;
            this.payloads.remove = ImmutableUnifiedMapTest::remove;
            this.payloads.newWithKeyValue = ImmutableUnifiedMapTest::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableUnifiedMapTest::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableUnifiedMapTest::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableUnifiedMapTest::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableUnifiedMapTest::withMapNull;
            this.payloads.newWithMapIterable = ImmutableUnifiedMapTest::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableUnifiedMapTest::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableUnifiedMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableUnifiedMapTest::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableUnifiedMapTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableUnifiedMapTest::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableUnifiedMapTest::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableUnifiedMapTest::newWithoutKeys;
            this.payloads.castToMap = ImmutableUnifiedMapTest::castToMap;
            this.payloads.toMap = ImmutableUnifiedMapTest::toMap;
            this.payloads.entrySet = ImmutableUnifiedMapTest::entrySet;
            this.payloads.testToString = ImmutableUnifiedMapTest::testToString;
            this.payloads.getBatchCount = ImmutableUnifiedMapTest::getBatchCount;
            this.payloads.batchForEach = ImmutableUnifiedMapTest::batchForEach;
        }
    }
*/
}
