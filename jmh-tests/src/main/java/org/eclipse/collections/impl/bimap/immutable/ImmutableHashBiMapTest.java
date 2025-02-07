/*
 * Copyright (c) 2021 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bimap.immutable;

import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.impl.bimap.mutable.HashBiMap;
import org.eclipse.collections.impl.factory.BiMaps;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableHashBiMapTest extends AbstractImmutableBiMapTestCase {

    @Override
    protected ImmutableBiMap<Integer, String> classUnderTest() {
        return BiMaps.immutable.with(1, "1", 2, "2", 3, "3", 4, "4");
    }

    @Override
    protected ImmutableBiMap<Integer, String> newEmpty() {
        return BiMaps.immutable.empty();
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithMap() {
        return BiMaps.immutable.withAll(UnifiedMap.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4"));
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithHashBiMap() {
        return BiMaps.immutable.withAll(HashBiMap.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4"));
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithImmutableMap() {
        return BiMaps.immutable.withAll(Maps.immutable.of(1, "1", 2, "2", 3, "3", 4, "4"));
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("{1=1, 2=2, 3=3, 4=4}", this.classUnderTest().toString());
    }

    @Test
    public void keySet() {
        Verify.assertSetsEqual(UnifiedSet.newSetWith(1, 2, 3, 4), this.classUnderTest().castToMap().keySet());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableHashBiMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

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
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithHashBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithHashBiMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithImmutableMap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableHashBiMapTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> testNewWithMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> testNewWithHashBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> testNewWithImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapTest> keySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.equalsAndHashCode = ImmutableHashBiMapTest::equalsAndHashCode;
            this.payloads.forEachKeyValue = ImmutableHashBiMapTest::forEachKeyValue;
            this.payloads.forEachValue = ImmutableHashBiMapTest::forEachValue;
            this.payloads.tap = ImmutableHashBiMapTest::tap;
            this.payloads.forEach = ImmutableHashBiMapTest::forEach;
            this.payloads.flipUniqueValues = ImmutableHashBiMapTest::flipUniqueValues;
            this.payloads.iterator = ImmutableHashBiMapTest::iterator;
            this.payloads.iteratorThrows = ImmutableHashBiMapTest::iteratorThrows;
            this.payloads.forEachKey = ImmutableHashBiMapTest::forEachKey;
            this.payloads.get = ImmutableHashBiMapTest::get;
            this.payloads.getIfAbsent_function = ImmutableHashBiMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableHashBiMapTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableHashBiMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableHashBiMapTest::getIfAbsentWith;
            this.payloads.ifPresentApply = ImmutableHashBiMapTest::ifPresentApply;
            this.payloads.notEmpty = ImmutableHashBiMapTest::notEmpty;
            this.payloads.forEachWith = ImmutableHashBiMapTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableHashBiMapTest::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableHashBiMapTest::keyValuesView;
            this.payloads.valuesView = ImmutableHashBiMapTest::valuesView;
            this.payloads.keysView = ImmutableHashBiMapTest::keysView;
            this.payloads.putAll = ImmutableHashBiMapTest::putAll;
            this.payloads.clear = ImmutableHashBiMapTest::clear;
            this.payloads.put = ImmutableHashBiMapTest::put;
            this.payloads.remove = ImmutableHashBiMapTest::remove;
            this.payloads.newWithKeyValue = ImmutableHashBiMapTest::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableHashBiMapTest::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableHashBiMapTest::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableHashBiMapTest::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableHashBiMapTest::withMapNull;
            this.payloads.newWithMapIterable = ImmutableHashBiMapTest::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableHashBiMapTest::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableHashBiMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableHashBiMapTest::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableHashBiMapTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableHashBiMapTest::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableHashBiMapTest::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableHashBiMapTest::newWithoutKeys;
            this.payloads.testNewEmpty = ImmutableHashBiMapTest::testNewEmpty;
            this.payloads.testNewWithMap = ImmutableHashBiMapTest::testNewWithMap;
            this.payloads.testNewWithHashBiMap = ImmutableHashBiMapTest::testNewWithHashBiMap;
            this.payloads.testNewWithImmutableMap = ImmutableHashBiMapTest::testNewWithImmutableMap;
            this.payloads.containsKey = ImmutableHashBiMapTest::containsKey;
            this.payloads.toImmutable = ImmutableHashBiMapTest::toImmutable;
            this.payloads.toMapTarget = ImmutableHashBiMapTest::toMapTarget;
            this.payloads.testToString = ImmutableHashBiMapTest::testToString;
            this.payloads.keySet = ImmutableHashBiMapTest::keySet;
        }
    }
}
