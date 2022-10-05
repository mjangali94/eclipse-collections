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

import java.util.NoSuchElementException;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableEmptyMap}.
 */
public class ImmutableEmptyMapTest extends ImmutableMemoryEfficientMapTestCase {

    @Override
    protected ImmutableMap<Integer, String> classUnderTest() {
        return new ImmutableEmptyMap<>();
    }

    @Override
    protected int size() {
        return 0;
    }

    @Override
    @Test
    public void testToString() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertEquals("{}", map.toString());
    }

    @Override
    @Test
    public void flipUniqueValues() {
        Verify.assertEmpty(this.classUnderTest().flipUniqueValues());
    }

    @Override
    @Test
    public void get() {
        // Absent key behavior
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Integer absentKey = this.size() + 1;
        Assert.assertNull(classUnderTest.get(absentKey));
        String absentValue = String.valueOf(absentKey);
        Assert.assertFalse(classUnderTest.containsValue(absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getIfAbsent_function() {
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsent(absentKey, new PassThruFunction0<>(absentValue)));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getOrDefault() {
        super.getOrDefault();
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getOrDefault(absentKey, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getIfAbsent() {
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsentValue(absentKey, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void getIfAbsentWith() {
        Integer absentKey = this.size() + 1;
        String absentValue = String.valueOf(absentKey);
        // Absent key behavior
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertEquals(absentValue, classUnderTest.getIfAbsentWith(absentKey, String::valueOf, absentValue));
        // Still unchanged
        Assert.assertEquals(this.equalUnifiedMap(), classUnderTest);
    }

    @Override
    @Test
    public void ifPresentApply() {
        Integer absentKey = this.size() + 1;
        ImmutableMap<Integer, String> classUnderTest = this.classUnderTest();
        Assert.assertNull(classUnderTest.ifPresentApply(absentKey, Functions.getPassThru()));
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void allSatisfy() {
        ImmutableMap<String, String> map = new ImmutableEmptyMap<>();
        Assert.assertTrue(map.allSatisfy(String.class::isInstance));
        Assert.assertTrue(map.allSatisfy("Monkey"::equals));
    }

    @Override
    @Test
    public void anySatisfy() {
        ImmutableMap<String, String> map = new ImmutableEmptyMap<>();
        Assert.assertFalse(map.anySatisfy(String.class::isInstance));
        Assert.assertFalse(map.anySatisfy("Monkey"::equals));
    }

    @Override
    @Test
    public void noneSatisfy() {
        ImmutableMap<String, String> map = new ImmutableEmptyMap<>();
        Assert.assertTrue(map.noneSatisfy(String.class::isInstance));
        Assert.assertTrue(map.noneSatisfy("Monkey"::equals));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        ImmutableMap<String, String> map = new ImmutableEmptyMap<>();
        map.max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        ImmutableMap<String, String> map = new ImmutableEmptyMap<>();
        map.maxBy(Functions.getStringPassThru());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        ImmutableMap<String, String> map = new ImmutableEmptyMap<>();
        map.min();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        ImmutableMap<String, String> map = new ImmutableEmptyMap<>();
        map.minBy(Functions.getStringPassThru());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        new ImmutableEmptyMap<>().getOnly();
    }

    @Override
    public void select() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> actual = map.select((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableEmptyMap.class, actual);
    }

    @Override
    public void reject() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> actual = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(ImmutableEmptyMap.class, actual);
    }

    @Override
    public void detect() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.detect((ignored1, ignored2) -> true));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableEmptyMap<>();
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableEmptyMapTest instance;

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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapWithFunction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapWithFunction);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
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
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
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
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableEmptyMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> castToMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> toMapWithFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.equalsAndHashCode = ImmutableEmptyMapTest::equalsAndHashCode;
            this.payloads.forEachKeyValue = ImmutableEmptyMapTest::forEachKeyValue;
            this.payloads.forEachValue = ImmutableEmptyMapTest::forEachValue;
            this.payloads.tap = ImmutableEmptyMapTest::tap;
            this.payloads.forEach = ImmutableEmptyMapTest::forEach;
            this.payloads.iterator = ImmutableEmptyMapTest::iterator;
            this.payloads.iteratorThrows = ImmutableEmptyMapTest::iteratorThrows;
            this.payloads.forEachKey = ImmutableEmptyMapTest::forEachKey;
            this.payloads.forEachWith = ImmutableEmptyMapTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableEmptyMapTest::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableEmptyMapTest::keyValuesView;
            this.payloads.valuesView = ImmutableEmptyMapTest::valuesView;
            this.payloads.keysView = ImmutableEmptyMapTest::keysView;
            this.payloads.putAll = ImmutableEmptyMapTest::putAll;
            this.payloads.clear = ImmutableEmptyMapTest::clear;
            this.payloads.put = ImmutableEmptyMapTest::put;
            this.payloads.remove = ImmutableEmptyMapTest::remove;
            this.payloads.newWithKeyValue = ImmutableEmptyMapTest::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableEmptyMapTest::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableEmptyMapTest::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableEmptyMapTest::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableEmptyMapTest::withMapNull;
            this.payloads.newWithMapIterable = ImmutableEmptyMapTest::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableEmptyMapTest::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableEmptyMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableEmptyMapTest::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableEmptyMapTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableEmptyMapTest::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableEmptyMapTest::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableEmptyMapTest::newWithoutKeys;
            this.payloads.castToMap = ImmutableEmptyMapTest::castToMap;
            this.payloads.toMap = ImmutableEmptyMapTest::toMap;
            this.payloads.entrySet = ImmutableEmptyMapTest::entrySet;
            this.payloads.select = ImmutableEmptyMapTest::select;
            this.payloads.reject = ImmutableEmptyMapTest::reject;
            this.payloads.detect = ImmutableEmptyMapTest::detect;
            this.payloads.collectValues = ImmutableEmptyMapTest::collectValues;
            this.payloads.collect = ImmutableEmptyMapTest::collect;
            this.payloads.appendString = ImmutableEmptyMapTest::appendString;
            this.payloads.toBag = ImmutableEmptyMapTest::toBag;
            this.payloads.asLazy = ImmutableEmptyMapTest::asLazy;
            this.payloads.toList = ImmutableEmptyMapTest::toList;
            this.payloads.toMapWithFunction = ImmutableEmptyMapTest::toMapWithFunction;
            this.payloads.toSet = ImmutableEmptyMapTest::toSet;
            this.payloads.toSortedList = ImmutableEmptyMapTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableEmptyMapTest::toSortedListBy;
            this.payloads.chunk = ImmutableEmptyMapTest::chunk;
            this.payloads.collect_value = ImmutableEmptyMapTest::collect_value;
            this.payloads.collectIf = ImmutableEmptyMapTest::collectIf;
            this.payloads.collectWith = ImmutableEmptyMapTest::collectWith;
            this.payloads.contains = ImmutableEmptyMapTest::contains;
            this.payloads.getFirst = ImmutableEmptyMapTest::getFirst;
            this.payloads.getLast = ImmutableEmptyMapTest::getLast;
            this.payloads.containsAllIterable = ImmutableEmptyMapTest::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableEmptyMapTest::containsAllArguments;
            this.payloads.count = ImmutableEmptyMapTest::count;
            this.payloads.detect_value = ImmutableEmptyMapTest::detect_value;
            this.payloads.detectIfNone_value = ImmutableEmptyMapTest::detectIfNone_value;
            this.payloads.flatCollect = ImmutableEmptyMapTest::flatCollect;
            this.payloads.groupBy = ImmutableEmptyMapTest::groupBy;
            this.payloads.groupByEach = ImmutableEmptyMapTest::groupByEach;
            this.payloads.injectInto = ImmutableEmptyMapTest::injectInto;
            this.payloads.makeString = ImmutableEmptyMapTest::makeString;
            this.payloads.reject_value = ImmutableEmptyMapTest::reject_value;
            this.payloads.rejectWith_value = ImmutableEmptyMapTest::rejectWith_value;
            this.payloads.select_value = ImmutableEmptyMapTest::select_value;
            this.payloads.selectWith_value = ImmutableEmptyMapTest::selectWith_value;
            this.payloads.partition_value = ImmutableEmptyMapTest::partition_value;
            this.payloads.partitionWith_value = ImmutableEmptyMapTest::partitionWith_value;
            this.payloads.toArray = ImmutableEmptyMapTest::toArray;
            this.payloads.zip = ImmutableEmptyMapTest::zip;
            this.payloads.zipWithIndex = ImmutableEmptyMapTest::zipWithIndex;
            this.payloads.testToString = ImmutableEmptyMapTest::testToString;
            this.payloads.flipUniqueValues = ImmutableEmptyMapTest::flipUniqueValues;
            this.payloads.get = ImmutableEmptyMapTest::get;
            this.payloads.getIfAbsent_function = ImmutableEmptyMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableEmptyMapTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableEmptyMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableEmptyMapTest::getIfAbsentWith;
            this.payloads.ifPresentApply = ImmutableEmptyMapTest::ifPresentApply;
            this.payloads.notEmpty = ImmutableEmptyMapTest::notEmpty;
            this.payloads.allSatisfy = ImmutableEmptyMapTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableEmptyMapTest::anySatisfy;
            this.payloads.noneSatisfy = ImmutableEmptyMapTest::noneSatisfy;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyMapTest::max, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyMapTest::maxBy, java.util.NoSuchElementException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyMapTest::min, java.util.NoSuchElementException.class);
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyMapTest::minBy, java.util.NoSuchElementException.class);
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyMapTest::getOnly, java.lang.IllegalStateException.class);
        }
    }
}
