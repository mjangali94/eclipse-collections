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

import java.util.HashMap;
import java.util.Map;
import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.factory.BiMaps;
import org.eclipse.collections.impl.map.immutable.ImmutableMapIterableTestCase;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractImmutableBiMapTestCase extends ImmutableMapIterableTestCase {

    @Override
    protected abstract ImmutableBiMap<Integer, String> classUnderTest();

    protected abstract ImmutableBiMap<Integer, String> newEmpty();

    protected abstract ImmutableBiMap<Integer, String> newWithMap();

    protected abstract ImmutableBiMap<Integer, String> newWithHashBiMap();

    protected abstract ImmutableBiMap<Integer, String> newWithImmutableMap();

    @Override
    protected int size() {
        return 4;
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("{1=1, 2=2, 3=3, 4=4}", this.classUnderTest().toString());
    }

    @Test
    public void testNewEmpty() {
        Assert.assertTrue(this.newEmpty().isEmpty());
    }

    @Test
    public void testNewWithMap() {
        Assert.assertEquals(this.classUnderTest(), this.newWithMap());
    }

    @Test
    public void testNewWithHashBiMap() {
        Assert.assertEquals(this.classUnderTest(), this.newWithHashBiMap());
    }

    @Test
    public void testNewWithImmutableMap() {
        Assert.assertEquals(this.classUnderTest(), this.newWithImmutableMap());
    }

    @Test
    public void containsKey() {
        Assert.assertTrue(this.classUnderTest().containsKey(1));
        Assert.assertFalse(this.classUnderTest().containsKey(5));
    }

    @Test
    public void toImmutable() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
    }

    @Test
    public void toMapTarget() {
        ImmutableBiMap<String, String> immutableBiMap = BiMaps.immutable.with("1", "1", "2", "2", "3", "3", "4", "4");
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("1", "1");
        expectedMap.put("2", "2");
        expectedMap.put("3", "3");
        expectedMap.put("4", "4");
        Map<String, String> actualMap = (Map<String, String>) immutableBiMap.toMap(Functions.getPassThru(), Functions.getPassThru(), expectedMap);
        Assert.assertEquals(expectedMap, actualMap);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractImmutableBiMapTestCase instance;

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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithHashBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithHashBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithImmutableMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableBiMapTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> testNewEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> testNewWithMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> testNewWithHashBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> testNewWithImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> containsKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableBiMapTestCase> toMapTarget;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.equalsAndHashCode = AbstractImmutableBiMapTestCase::equalsAndHashCode;
            this.payloads.forEachKeyValue = AbstractImmutableBiMapTestCase::forEachKeyValue;
            this.payloads.forEachValue = AbstractImmutableBiMapTestCase::forEachValue;
            this.payloads.tap = AbstractImmutableBiMapTestCase::tap;
            this.payloads.forEach = AbstractImmutableBiMapTestCase::forEach;
            this.payloads.flipUniqueValues = AbstractImmutableBiMapTestCase::flipUniqueValues;
            this.payloads.iterator = AbstractImmutableBiMapTestCase::iterator;
            this.payloads.iteratorThrows = AbstractImmutableBiMapTestCase::iteratorThrows;
            this.payloads.forEachKey = AbstractImmutableBiMapTestCase::forEachKey;
            this.payloads.get = AbstractImmutableBiMapTestCase::get;
            this.payloads.getIfAbsent_function = AbstractImmutableBiMapTestCase::getIfAbsent_function;
            this.payloads.getOrDefault = AbstractImmutableBiMapTestCase::getOrDefault;
            this.payloads.getIfAbsent = AbstractImmutableBiMapTestCase::getIfAbsent;
            this.payloads.getIfAbsentWith = AbstractImmutableBiMapTestCase::getIfAbsentWith;
            this.payloads.ifPresentApply = AbstractImmutableBiMapTestCase::ifPresentApply;
            this.payloads.notEmpty = AbstractImmutableBiMapTestCase::notEmpty;
            this.payloads.forEachWith = AbstractImmutableBiMapTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractImmutableBiMapTestCase::forEachWithIndex;
            this.payloads.keyValuesView = AbstractImmutableBiMapTestCase::keyValuesView;
            this.payloads.valuesView = AbstractImmutableBiMapTestCase::valuesView;
            this.payloads.keysView = AbstractImmutableBiMapTestCase::keysView;
            this.payloads.putAll = AbstractImmutableBiMapTestCase::putAll;
            this.payloads.clear = AbstractImmutableBiMapTestCase::clear;
            this.payloads.put = AbstractImmutableBiMapTestCase::put;
            this.payloads.remove = AbstractImmutableBiMapTestCase::remove;
            this.payloads.newWithKeyValue = AbstractImmutableBiMapTestCase::newWithKeyValue;
            this.payloads.newWithMap1 = AbstractImmutableBiMapTestCase::newWithMap1;
            this.payloads.newWithMapTargetEmpty = AbstractImmutableBiMapTestCase::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = AbstractImmutableBiMapTestCase::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = AbstractImmutableBiMapTestCase::withMapNull;
            this.payloads.newWithMapIterable = AbstractImmutableBiMapTestCase::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = AbstractImmutableBiMapTestCase::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = AbstractImmutableBiMapTestCase::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = AbstractImmutableBiMapTestCase::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = AbstractImmutableBiMapTestCase::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = AbstractImmutableBiMapTestCase::newWithAllKeyValues;
            this.payloads.newWithoutKey = AbstractImmutableBiMapTestCase::newWithoutKey;
            this.payloads.newWithoutKeys = AbstractImmutableBiMapTestCase::newWithoutKeys;
            this.payloads.testToString = AbstractImmutableBiMapTestCase::testToString;
            this.payloads.testNewEmpty = AbstractImmutableBiMapTestCase::testNewEmpty;
            this.payloads.testNewWithMap = AbstractImmutableBiMapTestCase::testNewWithMap;
            this.payloads.testNewWithHashBiMap = AbstractImmutableBiMapTestCase::testNewWithHashBiMap;
            this.payloads.testNewWithImmutableMap = AbstractImmutableBiMapTestCase::testNewWithImmutableMap;
            this.payloads.containsKey = AbstractImmutableBiMapTestCase::containsKey;
            this.payloads.toImmutable = AbstractImmutableBiMapTestCase::toImmutable;
            this.payloads.toMapTarget = AbstractImmutableBiMapTestCase::toMapTarget;
        }
    }
}
