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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ImmutableMapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.fixed.ArrayAdapter;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

public abstract class ImmutableMapIterableTestCase {

    /**
     * @return A map containing 1 => "1", 2 => "2", etc.
     */
    protected abstract ImmutableMapIterable<Integer, String> classUnderTest();

    /**
     * @return Size (and max key) of {@link #classUnderTest()}.
     */
    protected abstract int size();

    @Test
    public void equalsAndHashCode() {
        MutableMap<Integer, String> expected = this.equalUnifiedMap();
        Verify.assertEqualsAndHashCode(expected, this.classUnderTest());
        Verify.assertPostSerializedEqualsAndHashCode(this.classUnderTest());
    }

    @Test
    public void forEachKeyValue() {
        MutableSet<Integer> actualKeys = UnifiedSet.newSet();
        MutableSet<String> actualValues = UnifiedSet.newSet();
        this.classUnderTest().forEachKeyValue((key, value) -> {
            actualKeys.add(key);
            actualValues.add(value);
        });
        MutableSet<Integer> expectedKeys = this.expectedKeys();
        Assert.assertEquals(expectedKeys, actualKeys);
        MutableSet<String> expectedValues = expectedKeys.collect(String::valueOf);
        Assert.assertEquals(expectedValues, actualValues);
    }

    @Test
    public void forEachValue() {
        MutableSet<String> actualValues = UnifiedSet.newSet();
        this.classUnderTest().forEachValue(CollectionAddProcedure.on(actualValues));
        Assert.assertEquals(this.expectedValues(), actualValues);
    }

    @Test
    public void tap() {
        MutableList<String> tapResult = Lists.mutable.of();
        ImmutableMapIterable<Integer, String> map = this.classUnderTest();
        Assert.assertSame(map, map.tap(tapResult::add));
        Assert.assertEquals(map.toList(), tapResult);
    }

    @Test
    public void forEach() {
        MutableSet<String> actualValues = UnifiedSet.newSet();
        this.classUnderTest().forEach(CollectionAddProcedure.on(actualValues));
        Assert.assertEquals(this.expectedValues(), actualValues);
    }

    @Test
    public void flipUniqueValues() {
        ImmutableMapIterable<Integer, String> immutableMap = this.classUnderTest();
        Assert.assertEquals(Interval.oneTo(this.size()).toMap(String::valueOf, Functions.getIntegerPassThru()), immutableMap.flipUniqueValues());
    }

    @Test
    public void iterator() {
        MutableSet<String> actualValues = UnifiedSet.newSet();
        for (String eachValue : this.classUnderTest()) {
            actualValues.add(eachValue);
        }
        Assert.assertEquals(this.expectedValues(), actualValues);
    }

    @Test
    public void iteratorThrows() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> {
            Iterator<String> iterator = this.classUnderTest().iterator();
            iterator.remove();
        });
    }

    @Test
    public void forEachKey() {
        MutableSet<Integer> actualKeys = UnifiedSet.newSet();
        this.classUnderTest().forEachKey(CollectionAddProcedure.on(actualKeys));
        Assert.assertEquals(this.expectedKeys(), actualKeys);
    }

    @Test
    public void get() {
        // Absent key behavior
        ImmutableMapIterable<Integer, String> classUnderTest = this.classUnderTest();
        Integer absentKey = this.size() + 1;
        Assert.assertNull(classUnderTest.get(absentKey));
        String absentValue = String.valueOf(absentKey);
        Assert.assertFalse(classUnderTest.containsValue(absentValue));
        // Present key behavior
        Assert.assertEquals("1", classUnderTest.get(1));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Test
    public void getIfAbsent_function() {
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMapIterable<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsent(absentKey, new PassThruFunction0<>(absentValue)));
        // Present key behavior
        Assert.assertEquals("1", classUnderTest.getIfAbsent(1, new PassThruFunction0<>(absentValue)));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Test
    public void getOrDefault() {
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMapIterable<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getOrDefault(absentKey, absentValue));
        // Present key behavior
        Assert.assertEquals("1", classUnderTest.getOrDefault(1, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Test
    public void getIfAbsent() {
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMapIterable<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsentValue(absentKey, absentValue));
        // Present key behavior
        Assert.assertEquals("1", classUnderTest.getIfAbsentValue(1, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Test
    public void getIfAbsentWith() {
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMapIterable<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsentWith(absentKey, String::valueOf, absentValue));
        // Present key behavior
        Assert.assertEquals("1", classUnderTest.getIfAbsentWith(1, String::valueOf, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Test
    public void ifPresentApply() {
        Integer absentKey = this.size() + 1;
        ImmutableMapIterable<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertNull(classUnderTest.ifPresentApply(absentKey, Functions.getPassThru()));
        Assert.assertEquals("1", classUnderTest.ifPresentApply(1, Functions.getPassThru()));
    }

    @Test
    public void notEmpty() {
        Assert.assertTrue(this.classUnderTest().notEmpty());
    }

    @Test
    public void forEachWith() {
        Object actualParameter = new Object();
        MutableSet<String> actualValues = UnifiedSet.newSet();
        MutableList<Object> actualParameters = Lists.mutable.of();
        this.classUnderTest().forEachWith((eachValue, parameter) -> {
            actualValues.add(eachValue);
            actualParameters.add(parameter);
        }, actualParameter);
        Assert.assertEquals(this.expectedKeys().collect(String::valueOf), actualValues);
        Assert.assertEquals(Collections.nCopies(this.size(), actualParameter), actualParameters);
    }

    @Test
    public void forEachWithIndex() {
        MutableSet<String> actualValues = UnifiedSet.newSet();
        MutableList<Integer> actualIndices = Lists.mutable.of();
        this.classUnderTest().forEachWithIndex((eachValue, index) -> {
            actualValues.add(eachValue);
            actualIndices.add(index);
        });
        Assert.assertEquals(this.expectedKeys().collect(String::valueOf), actualValues);
        Assert.assertEquals(this.expectedIndices(), actualIndices);
    }

    @Test
    public void keyValuesView() {
        MutableSet<Integer> actualKeys = UnifiedSet.newSet();
        MutableSet<String> actualValues = UnifiedSet.newSet();
        for (Pair<Integer, String> entry : this.classUnderTest().keyValuesView()) {
            actualKeys.add(entry.getOne());
            actualValues.add(entry.getTwo());
        }
        MutableSet<Integer> expectedKeys = this.expectedKeys();
        Assert.assertEquals(expectedKeys, actualKeys);
        MutableSet<String> expectedValues = expectedKeys.collect(String::valueOf);
        Assert.assertEquals(expectedValues, actualValues);
    }

    @Test
    public void valuesView() {
        MutableSet<String> actualValues = UnifiedSet.newSet();
        for (String eachValue : this.classUnderTest().valuesView()) {
            actualValues.add(eachValue);
        }
        MutableSet<String> expectedValues = this.expectedValues();
        Assert.assertEquals(expectedValues, actualValues);
    }

    @Test
    public void keysView() {
        MutableSet<Integer> actualKeys = UnifiedSet.newSet();
        for (Integer eachKey : this.classUnderTest().keysView()) {
            actualKeys.add(eachKey);
        }
        Assert.assertEquals(this.expectedKeys(), actualKeys);
    }

    @Test
    public void putAll() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Map<Integer, String>) this.classUnderTest()).putAll(null));
    }

    @Test
    public void clear() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Map<Integer, String>) this.classUnderTest()).clear());
    }

    @Test
    public void put() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Map<Integer, String>) this.classUnderTest()).put(null, null));
    }

    @Test
    public void remove() {
        Assert.assertThrows(UnsupportedOperationException.class, () -> ((Map<Integer, String>) this.classUnderTest()).remove(null));
    }

    @Test
    public abstract void testToString();

    protected MutableMap<Integer, String> equalUnifiedMap() {
        MutableMap<Integer, String> expected = UnifiedMap.newMap();
        for (int i = 1; i <= this.size(); i++) {
            expected.put(i, String.valueOf(i));
        }
        return expected;
    }

    private MutableSet<String> expectedValues() {
        return this.expectedKeys().collect(String::valueOf);
    }

    private MutableSet<Integer> expectedKeys() {
        if (this.size() == 0) {
            return UnifiedSet.newSet();
        }
        return Interval.oneTo(this.size()).toSet();
    }

    private List<Integer> expectedIndices() {
        if (this.size() == 0) {
            return Lists.mutable.of();
        }
        return Interval.zeroTo(this.size() - 1);
    }

    @Test
    public void newWithKeyValue() {
        ImmutableMapIterable<Integer, String> immutable = this.classUnderTest();
        ImmutableMapIterable<Integer, String> immutable2 = immutable.newWithKeyValue(Integer.MAX_VALUE, Integer.toString(Integer.MAX_VALUE));
        Verify.assertSize(immutable.size() + 1, immutable2);
    }

    @Test
    public void newWithMap1() {
        ImmutableMapIterable<Integer, String> immutable = this.classUnderTest();
        ImmutableMapIterable<Integer, String> immutable2 = immutable.newWithMap(UnifiedMap.newMapWith(Tuples.pair(Integer.MAX_VALUE, Integer.toString(Integer.MAX_VALUE)), Tuples.pair(Integer.MIN_VALUE, Integer.toString(Integer.MIN_VALUE))));
        MutableMap<Integer, String> mutableMap = Maps.mutable.withMap(immutable.castToMap());
        MutableMap<Integer, String> mutableMap2 = Maps.mutable.withMap(immutable2.castToMap());
        mutableMap.putAll(mutableMap2);
        Verify.assertMapsEqual(mutableMap, mutableMap2);
        Verify.assertSize(immutable.size() + 2, immutable2);
    }

    @Test
    public void newWithMapTargetEmpty() {
        ImmutableMapIterable<Integer, String> immutable = this.classUnderTest();
        ImmutableMapIterable<Integer, String> immutable2 = immutable.newWithMap(Maps.mutable.empty());
        MutableMap<Integer, String> mutableMap = Maps.mutable.withMap(immutable.castToMap());
        MutableMap<Integer, String> mutableMap2 = Maps.mutable.withMap(immutable2.castToMap());
        mutableMap.putAll(mutableMap2);
        Verify.assertMapsEqual(mutableMap, mutableMap2);
        Verify.assertSize(immutable.size(), immutable2);
    }

    @Test
    public void newWithMapEmptyAndTargetEmpty() {
        ImmutableMapIterable<Integer, String> immutable = Maps.immutable.empty();
        ImmutableMapIterable<Integer, String> immutable2 = immutable.newWithMap(Maps.mutable.empty());
        MutableMap<Integer, String> mutableMap = Maps.mutable.withMap(immutable.castToMap());
        MutableMap<Integer, String> mutableMap2 = Maps.mutable.withMap(immutable2.castToMap());
        mutableMap.putAll(mutableMap2);
        Verify.assertMapsEqual(mutableMap, mutableMap2);
        Verify.assertSize(immutable.size(), immutable2);
    }

    @Test
    public void withMapNull() {
        Assert.assertThrows(NullPointerException.class, () -> this.classUnderTest().newWithMap(null));
    }

    @Test
    public void newWithMapIterable() {
        ImmutableMapIterable<Integer, String> immutable = this.classUnderTest();
        ImmutableMapIterable<Integer, String> immutable2 = immutable.newWithMapIterable(Maps.immutable.of(Integer.MAX_VALUE, Integer.toString(Integer.MAX_VALUE), Integer.MIN_VALUE, Integer.toString(Integer.MIN_VALUE)));
        MutableMap<Integer, String> mutableMap = Maps.mutable.withMap(immutable.castToMap());
        MutableMap<Integer, String> mutableMap2 = Maps.mutable.withMap(immutable2.castToMap());
        mutableMap.putAll(mutableMap2);
        Verify.assertMapsEqual(mutableMap, mutableMap2);
        Verify.assertSize(immutable.size() + 2, immutable2);
    }

    @Test
    public void newWithMapIterableTargetEmpty() {
        ImmutableMapIterable<Integer, String> immutable = this.classUnderTest();
        ImmutableMapIterable<Integer, String> immutable2 = immutable.newWithMapIterable(Maps.immutable.empty());
        MutableMap<Integer, String> mutableMap = Maps.mutable.withMap(immutable.castToMap());
        MutableMap<Integer, String> mutableMap2 = Maps.mutable.withMap(immutable2.castToMap());
        mutableMap.putAll(mutableMap2);
        Verify.assertMapsEqual(mutableMap, mutableMap2);
        Verify.assertSize(immutable.size(), immutable2);
    }

    @Test
    public void withMapIterableEmptyAndTargetEmpty() {
        ImmutableMapIterable<Integer, String> immutable = this.classUnderTest();
        ImmutableMapIterable<Integer, String> immutable2 = immutable.newWithMapIterable(Maps.immutable.empty());
        MutableMap<Integer, String> mutableMap = Maps.mutable.withMap(immutable.castToMap());
        MutableMap<Integer, String> mutableMap2 = Maps.mutable.withMap(immutable2.castToMap());
        mutableMap.putAll(mutableMap2);
        Verify.assertMapsEqual(mutableMap, mutableMap2);
        Verify.assertSize(immutable.size(), immutable2);
    }

    @Test
    public void withMapIterableNull() {
        Assert.assertThrows(NullPointerException.class, () -> this.classUnderTest().newWithMapIterable(null));
    }

    @Test
    public void newWithAllKeyValuePairs() {
        ImmutableMapIterable<Integer, String> immutable = this.classUnderTest();
        ImmutableMapIterable<Integer, String> immutable2 = immutable.newWithAllKeyValueArguments(Tuples.pair(Integer.MAX_VALUE, Integer.toString(Integer.MAX_VALUE)), Tuples.pair(Integer.MIN_VALUE, Integer.toString(Integer.MIN_VALUE)));
        Verify.assertSize(immutable.size() + 2, immutable2);
    }

    @Test
    public void newWithAllKeyValues() {
        ImmutableMapIterable<Integer, String> immutable = this.classUnderTest();
        ImmutableMapIterable<Integer, String> immutable2 = immutable.newWithAllKeyValues(ArrayAdapter.newArrayWith(Tuples.pair(Integer.MAX_VALUE, Integer.toString(Integer.MAX_VALUE)), Tuples.pair(Integer.MIN_VALUE, Integer.toString(Integer.MIN_VALUE))));
        Verify.assertSize(immutable.size() + 2, immutable2);
    }

    @Test
    public void newWithoutKey() {
        ImmutableMapIterable<Integer, String> immutable = this.classUnderTest();
        ImmutableMapIterable<Integer, String> immutable3 = immutable.newWithoutKey(Integer.MAX_VALUE);
        Verify.assertSize(immutable.size(), immutable3);
    }

    @Test
    public void newWithoutKeys() {
        ImmutableMapIterable<Integer, String> immutable = this.classUnderTest();
        ImmutableMapIterable<Integer, String> immutable2 = immutable.newWithoutAllKeys(immutable.keysView());
        ImmutableMapIterable<Integer, String> immutable3 = immutable.newWithoutAllKeys(Lists.immutable.of());
        Assert.assertEquals(immutable, immutable3);
        Assert.assertEquals(Maps.immutable.of(), immutable2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableMapIterableTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new ImmutableMapIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableMapIterableTestCase> newWithoutKeys;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.equalsAndHashCode = ImmutableMapIterableTestCase::equalsAndHashCode;
            this.payloads.forEachKeyValue = ImmutableMapIterableTestCase::forEachKeyValue;
            this.payloads.forEachValue = ImmutableMapIterableTestCase::forEachValue;
            this.payloads.tap = ImmutableMapIterableTestCase::tap;
            this.payloads.forEach = ImmutableMapIterableTestCase::forEach;
            this.payloads.flipUniqueValues = ImmutableMapIterableTestCase::flipUniqueValues;
            this.payloads.iterator = ImmutableMapIterableTestCase::iterator;
            this.payloads.iteratorThrows = ImmutableMapIterableTestCase::iteratorThrows;
            this.payloads.forEachKey = ImmutableMapIterableTestCase::forEachKey;
            this.payloads.get = ImmutableMapIterableTestCase::get;
            this.payloads.getIfAbsent_function = ImmutableMapIterableTestCase::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableMapIterableTestCase::getOrDefault;
            this.payloads.getIfAbsent = ImmutableMapIterableTestCase::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableMapIterableTestCase::getIfAbsentWith;
            this.payloads.ifPresentApply = ImmutableMapIterableTestCase::ifPresentApply;
            this.payloads.notEmpty = ImmutableMapIterableTestCase::notEmpty;
            this.payloads.forEachWith = ImmutableMapIterableTestCase::forEachWith;
            this.payloads.forEachWithIndex = ImmutableMapIterableTestCase::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableMapIterableTestCase::keyValuesView;
            this.payloads.valuesView = ImmutableMapIterableTestCase::valuesView;
            this.payloads.keysView = ImmutableMapIterableTestCase::keysView;
            this.payloads.putAll = ImmutableMapIterableTestCase::putAll;
            this.payloads.clear = ImmutableMapIterableTestCase::clear;
            this.payloads.put = ImmutableMapIterableTestCase::put;
            this.payloads.remove = ImmutableMapIterableTestCase::remove;
            this.payloads.testToString = ImmutableMapIterableTestCase::testToString;
            this.payloads.newWithKeyValue = ImmutableMapIterableTestCase::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableMapIterableTestCase::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableMapIterableTestCase::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableMapIterableTestCase::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableMapIterableTestCase::withMapNull;
            this.payloads.newWithMapIterable = ImmutableMapIterableTestCase::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableMapIterableTestCase::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableMapIterableTestCase::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableMapIterableTestCase::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableMapIterableTestCase::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableMapIterableTestCase::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableMapIterableTestCase::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableMapIterableTestCase::newWithoutKeys;
        }
    }
}
