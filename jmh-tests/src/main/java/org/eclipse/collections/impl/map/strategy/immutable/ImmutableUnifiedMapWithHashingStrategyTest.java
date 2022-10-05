/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.strategy.immutable;

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.map.immutable.ImmutableMapTestCase;
import org.eclipse.collections.impl.map.strategy.mutable.UnifiedMapWithHashingStrategy;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.math.Sum;
import org.eclipse.collections.impl.parallel.BatchIterable;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableUnifiedMapWithHashingStrategyTest extends ImmutableMapTestCase {

    // Not using the static factor method in order to have concrete types for test cases
    private static final HashingStrategy<Integer> HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>() {

        public int computeHashCode(Integer object) {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2) {
            return object1.equals(object2);
        }
    });

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        ImmutableMap<Integer, String> deserialized = SerializeTestHelper.serializeDeserialize(this.classUnderTest());
        Verify.assertInstanceOf(ImmutableUnifiedMapWithHashingStrategy.class, deserialized);
    }

    @Override
    protected ImmutableMap<Integer, String> classUnderTest() {
        return UnifiedMapWithHashingStrategy.newWithKeysValues(HASHING_STRATEGY, 1, "1", 2, "2", 3, "3", 4, "4").toImmutable();
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

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableUnifiedMapWithHashingStrategyTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent_function);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOrDefault);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsent);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.ifPresentApply);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keyValuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keyValuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_valuesView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.valuesView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keysView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keysView);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMap1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMap1);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithMapIterableTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithMapIterableTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableEmptyAndTargetEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableEmptyAndTargetEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withMapIterableNull() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withMapIterableNull);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAllKeyValuePairs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAllKeyValuePairs);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithAllKeyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithAllKeyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newWithoutKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithoutKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_castToMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.castToMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getBatchCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getBatchCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_batchForEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.batchForEach);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableUnifiedMapWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> castToMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> getBatchCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableUnifiedMapWithHashingStrategyTest> batchForEach;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEachKeyValue = ImmutableUnifiedMapWithHashingStrategyTest::forEachKeyValue;
            this.payloads.forEachValue = ImmutableUnifiedMapWithHashingStrategyTest::forEachValue;
            this.payloads.tap = ImmutableUnifiedMapWithHashingStrategyTest::tap;
            this.payloads.forEach = ImmutableUnifiedMapWithHashingStrategyTest::forEach;
            this.payloads.flipUniqueValues = ImmutableUnifiedMapWithHashingStrategyTest::flipUniqueValues;
            this.payloads.iterator = ImmutableUnifiedMapWithHashingStrategyTest::iterator;
            this.payloads.iteratorThrows = ImmutableUnifiedMapWithHashingStrategyTest::iteratorThrows;
            this.payloads.forEachKey = ImmutableUnifiedMapWithHashingStrategyTest::forEachKey;
            this.payloads.get = ImmutableUnifiedMapWithHashingStrategyTest::get;
            this.payloads.getIfAbsent_function = ImmutableUnifiedMapWithHashingStrategyTest::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableUnifiedMapWithHashingStrategyTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableUnifiedMapWithHashingStrategyTest::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableUnifiedMapWithHashingStrategyTest::getIfAbsentWith;
            this.payloads.ifPresentApply = ImmutableUnifiedMapWithHashingStrategyTest::ifPresentApply;
            this.payloads.notEmpty = ImmutableUnifiedMapWithHashingStrategyTest::notEmpty;
            this.payloads.forEachWith = ImmutableUnifiedMapWithHashingStrategyTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableUnifiedMapWithHashingStrategyTest::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableUnifiedMapWithHashingStrategyTest::keyValuesView;
            this.payloads.valuesView = ImmutableUnifiedMapWithHashingStrategyTest::valuesView;
            this.payloads.keysView = ImmutableUnifiedMapWithHashingStrategyTest::keysView;
            this.payloads.putAll = ImmutableUnifiedMapWithHashingStrategyTest::putAll;
            this.payloads.clear = ImmutableUnifiedMapWithHashingStrategyTest::clear;
            this.payloads.put = ImmutableUnifiedMapWithHashingStrategyTest::put;
            this.payloads.remove = ImmutableUnifiedMapWithHashingStrategyTest::remove;
            this.payloads.newWithKeyValue = ImmutableUnifiedMapWithHashingStrategyTest::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableUnifiedMapWithHashingStrategyTest::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableUnifiedMapWithHashingStrategyTest::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableUnifiedMapWithHashingStrategyTest::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableUnifiedMapWithHashingStrategyTest::withMapNull;
            this.payloads.newWithMapIterable = ImmutableUnifiedMapWithHashingStrategyTest::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableUnifiedMapWithHashingStrategyTest::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableUnifiedMapWithHashingStrategyTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableUnifiedMapWithHashingStrategyTest::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableUnifiedMapWithHashingStrategyTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableUnifiedMapWithHashingStrategyTest::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableUnifiedMapWithHashingStrategyTest::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableUnifiedMapWithHashingStrategyTest::newWithoutKeys;
            this.payloads.castToMap = ImmutableUnifiedMapWithHashingStrategyTest::castToMap;
            this.payloads.toMap = ImmutableUnifiedMapWithHashingStrategyTest::toMap;
            this.payloads.entrySet = ImmutableUnifiedMapWithHashingStrategyTest::entrySet;
            this.payloads.equalsAndHashCode = ImmutableUnifiedMapWithHashingStrategyTest::equalsAndHashCode;
            this.payloads.testToString = ImmutableUnifiedMapWithHashingStrategyTest::testToString;
            this.payloads.getBatchCount = ImmutableUnifiedMapWithHashingStrategyTest::getBatchCount;
            this.payloads.batchForEach = ImmutableUnifiedMapWithHashingStrategyTest::batchForEach;
        }
    }
}
