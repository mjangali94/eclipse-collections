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

public class ImmutableHashBiMapInverseTest extends AbstractImmutableBiMapTestCase {

    @Override
    protected ImmutableBiMap<Integer, String> classUnderTest() {
        return BiMaps.immutable.with("1", 1, "2", 2, "3", 3, "4", 4).inverse();
    }

    @Override
    protected ImmutableBiMap<Integer, String> newEmpty() {
        return BiMaps.immutable.<String, Integer>empty().inverse();
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithMap() {
        return BiMaps.immutable.withAll(UnifiedMap.newWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4)).inverse();
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithHashBiMap() {
        return BiMaps.immutable.withAll(HashBiMap.newWithKeysValues("1", 1, "2", 2, "3", 3, "4", 4)).inverse();
    }

    @Override
    protected ImmutableBiMap<Integer, String> newWithImmutableMap() {
        return BiMaps.immutable.withAll(Maps.immutable.of("1", 1, "2", 2, "3", 3, "4", 4)).inverse();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public ImmutableHashBiMapInverseTest instance;

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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableHashBiMapInverseTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> testNewWithMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> testNewWithHashBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> testNewWithImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableHashBiMapInverseTest> toMapTarget;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.equalsAndHashCode = ImmutableHashBiMapInverseTest::equalsAndHashCode;
            this.payloads.forEachKeyValue = ImmutableHashBiMapInverseTest::forEachKeyValue;
            this.payloads.forEachValue = ImmutableHashBiMapInverseTest::forEachValue;
            this.payloads.tap = ImmutableHashBiMapInverseTest::tap;
            this.payloads.forEach = ImmutableHashBiMapInverseTest::forEach;
            this.payloads.flipUniqueValues = ImmutableHashBiMapInverseTest::flipUniqueValues;
            this.payloads.iterator = ImmutableHashBiMapInverseTest::iterator;
            this.payloads.iteratorThrows = ImmutableHashBiMapInverseTest::iteratorThrows;
            this.payloads.forEachKey = ImmutableHashBiMapInverseTest::forEachKey;
            this.payloads.get = ImmutableHashBiMapInverseTest::get;
            this.payloads.getIfAbsent_function = ImmutableHashBiMapInverseTest::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableHashBiMapInverseTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableHashBiMapInverseTest::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableHashBiMapInverseTest::getIfAbsentWith;
            this.payloads.ifPresentApply = ImmutableHashBiMapInverseTest::ifPresentApply;
            this.payloads.notEmpty = ImmutableHashBiMapInverseTest::notEmpty;
            this.payloads.forEachWith = ImmutableHashBiMapInverseTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableHashBiMapInverseTest::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableHashBiMapInverseTest::keyValuesView;
            this.payloads.valuesView = ImmutableHashBiMapInverseTest::valuesView;
            this.payloads.keysView = ImmutableHashBiMapInverseTest::keysView;
            this.payloads.putAll = ImmutableHashBiMapInverseTest::putAll;
            this.payloads.clear = ImmutableHashBiMapInverseTest::clear;
            this.payloads.put = ImmutableHashBiMapInverseTest::put;
            this.payloads.remove = ImmutableHashBiMapInverseTest::remove;
            this.payloads.newWithKeyValue = ImmutableHashBiMapInverseTest::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableHashBiMapInverseTest::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableHashBiMapInverseTest::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableHashBiMapInverseTest::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableHashBiMapInverseTest::withMapNull;
            this.payloads.newWithMapIterable = ImmutableHashBiMapInverseTest::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableHashBiMapInverseTest::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableHashBiMapInverseTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableHashBiMapInverseTest::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableHashBiMapInverseTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableHashBiMapInverseTest::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableHashBiMapInverseTest::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableHashBiMapInverseTest::newWithoutKeys;
            this.payloads.testToString = ImmutableHashBiMapInverseTest::testToString;
            this.payloads.testNewEmpty = ImmutableHashBiMapInverseTest::testNewEmpty;
            this.payloads.testNewWithMap = ImmutableHashBiMapInverseTest::testNewWithMap;
            this.payloads.testNewWithHashBiMap = ImmutableHashBiMapInverseTest::testNewWithHashBiMap;
            this.payloads.testNewWithImmutableMap = ImmutableHashBiMapInverseTest::testNewWithImmutableMap;
            this.payloads.containsKey = ImmutableHashBiMapInverseTest::containsKey;
            this.payloads.toImmutable = ImmutableHashBiMapInverseTest::toImmutable;
            this.payloads.toMapTarget = ImmutableHashBiMapInverseTest::toMapTarget;
        }
    }
}
