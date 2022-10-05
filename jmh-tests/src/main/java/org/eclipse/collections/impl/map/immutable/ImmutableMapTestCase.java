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

import java.util.HashMap;
import java.util.Map;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MutableMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableMap}.
 */
public abstract class ImmutableMapTestCase extends ImmutableMapIterableTestCase {

    @Override
    protected abstract ImmutableMap<Integer, String> classUnderTest();

    @Test
    public void castToMap() {
        ImmutableMap<Integer, String> immutable = this.classUnderTest();
        Map<Integer, String> map = immutable.castToMap();
        Assert.assertSame(immutable, map);
        Assert.assertEquals(immutable, new HashMap<>(map));
    }

    @Test
    public void toMap() {
        ImmutableMap<Integer, String> immutable = this.classUnderTest();
        MutableMap<Integer, String> map = immutable.toMap();
        Assert.assertNotSame(immutable, map);
        Assert.assertEquals(immutable, map);
    }

    @Test
    public void entrySet() {
        ImmutableMap<Integer, String> immutable = this.classUnderTest();
        Map<Integer, String> map = new HashMap<>(immutable.castToMap());
        Assert.assertEquals(immutable.size(), immutable.castToMap().entrySet().size());
        Assert.assertEquals(map.entrySet(), immutable.castToMap().entrySet());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableMapTestCase instance;

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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new ImmutableMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> castToMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapTestCase> entrySet;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.equalsAndHashCode = ImmutableMapTestCase::equalsAndHashCode;
            this.payloads.forEachKeyValue = ImmutableMapTestCase::forEachKeyValue;
            this.payloads.forEachValue = ImmutableMapTestCase::forEachValue;
            this.payloads.tap = ImmutableMapTestCase::tap;
            this.payloads.forEach = ImmutableMapTestCase::forEach;
            this.payloads.flipUniqueValues = ImmutableMapTestCase::flipUniqueValues;
            this.payloads.iterator = ImmutableMapTestCase::iterator;
            this.payloads.iteratorThrows = ImmutableMapTestCase::iteratorThrows;
            this.payloads.forEachKey = ImmutableMapTestCase::forEachKey;
            this.payloads.get = ImmutableMapTestCase::get;
            this.payloads.getIfAbsent_function = ImmutableMapTestCase::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableMapTestCase::getOrDefault;
            this.payloads.getIfAbsent = ImmutableMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableMapTestCase::getIfAbsentWith;
            this.payloads.ifPresentApply = ImmutableMapTestCase::ifPresentApply;
            this.payloads.notEmpty = ImmutableMapTestCase::notEmpty;
            this.payloads.forEachWith = ImmutableMapTestCase::forEachWith;
            this.payloads.forEachWithIndex = ImmutableMapTestCase::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableMapTestCase::keyValuesView;
            this.payloads.valuesView = ImmutableMapTestCase::valuesView;
            this.payloads.keysView = ImmutableMapTestCase::keysView;
            this.payloads.putAll = ImmutableMapTestCase::putAll;
            this.payloads.clear = ImmutableMapTestCase::clear;
            this.payloads.put = ImmutableMapTestCase::put;
            this.payloads.remove = ImmutableMapTestCase::remove;
            this.payloads.testToString = ImmutableMapTestCase::testToString;
            this.payloads.newWithKeyValue = ImmutableMapTestCase::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableMapTestCase::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableMapTestCase::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableMapTestCase::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableMapTestCase::withMapNull;
            this.payloads.newWithMapIterable = ImmutableMapTestCase::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableMapTestCase::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableMapTestCase::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableMapTestCase::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableMapTestCase::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableMapTestCase::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableMapTestCase::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableMapTestCase::newWithoutKeys;
            this.payloads.castToMap = ImmutableMapTestCase::castToMap;
            this.payloads.toMap = ImmutableMapTestCase::toMap;
            this.payloads.entrySet = ImmutableMapTestCase::entrySet;
        }
    }
}
