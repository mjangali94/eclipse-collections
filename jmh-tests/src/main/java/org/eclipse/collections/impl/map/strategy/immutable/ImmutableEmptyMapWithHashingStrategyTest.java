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

import java.util.NoSuchElementException;
import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.map.immutable.ImmutableMemoryEfficientMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableEmptyMapWithHashingStrategy}.
 */
public class ImmutableEmptyMapWithHashingStrategyTest extends ImmutableMemoryEfficientMapTestCase {

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
    protected ImmutableMap<Integer, String> classUnderTest() {
        return new ImmutableEmptyMapWithHashingStrategy<>(HASHING_STRATEGY);
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
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertTrue(map.allSatisfy(String.class::isInstance));
        Assert.assertTrue(map.allSatisfy("Monkey"::equals));
    }

    @Override
    @Test
    public void noneSatisfy() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertTrue(map.noneSatisfy(Integer.class::isInstance));
        Assert.assertTrue(map.noneSatisfy("Monkey"::equals));
    }

    @Override
    @Test
    public void anySatisfy() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertFalse(map.anySatisfy(String.class::isInstance));
        Assert.assertFalse(map.anySatisfy("Monkey"::equals));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        map.max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void maxBy() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        map.maxBy(Functions.getStringPassThru());
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        map.min();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void minBy() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        map.minBy(Functions.getStringPassThru());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly() {
        this.classUnderTest().getOnly();
    }

    @Override
    public void select() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> actual = map.select((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableEmptyMapWithHashingStrategy.class, actual);
    }

    @Override
    public void reject() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> actual = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(ImmutableEmptyMapWithHashingStrategy.class, actual);
    }

    @Override
    public void detect() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.detect((ignored1, ignored2) -> true));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableEmptyMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableEmptyMapWithHashingStrategyTest instance;

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
        public void benchmark_select() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapWithFunction() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapWithFunction);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.count);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIfNone_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.select_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith_value);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
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
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableEmptyMapWithHashingStrategyTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> castToMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> toMapWithFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableEmptyMapWithHashingStrategyTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.equalsAndHashCode = ImmutableEmptyMapWithHashingStrategyTest::equalsAndHashCode;
            this.payloads.forEachKeyValue = ImmutableEmptyMapWithHashingStrategyTest::forEachKeyValue;
            this.payloads.forEachValue = ImmutableEmptyMapWithHashingStrategyTest::forEachValue;
            this.payloads.tap = ImmutableEmptyMapWithHashingStrategyTest::tap;
            this.payloads.forEach = ImmutableEmptyMapWithHashingStrategyTest::forEach;
            this.payloads.iterator = ImmutableEmptyMapWithHashingStrategyTest::iterator;
            this.payloads.iteratorThrows = ImmutableEmptyMapWithHashingStrategyTest::iteratorThrows;
            this.payloads.forEachKey = ImmutableEmptyMapWithHashingStrategyTest::forEachKey;
            this.payloads.forEachWith = ImmutableEmptyMapWithHashingStrategyTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableEmptyMapWithHashingStrategyTest::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableEmptyMapWithHashingStrategyTest::keyValuesView;
            this.payloads.valuesView = ImmutableEmptyMapWithHashingStrategyTest::valuesView;
            this.payloads.keysView = ImmutableEmptyMapWithHashingStrategyTest::keysView;
            this.payloads.putAll = ImmutableEmptyMapWithHashingStrategyTest::putAll;
            this.payloads.clear = ImmutableEmptyMapWithHashingStrategyTest::clear;
            this.payloads.put = ImmutableEmptyMapWithHashingStrategyTest::put;
            this.payloads.remove = ImmutableEmptyMapWithHashingStrategyTest::remove;
            this.payloads.newWithKeyValue = ImmutableEmptyMapWithHashingStrategyTest::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableEmptyMapWithHashingStrategyTest::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableEmptyMapWithHashingStrategyTest::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableEmptyMapWithHashingStrategyTest::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableEmptyMapWithHashingStrategyTest::withMapNull;
            this.payloads.newWithMapIterable = ImmutableEmptyMapWithHashingStrategyTest::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableEmptyMapWithHashingStrategyTest::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableEmptyMapWithHashingStrategyTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableEmptyMapWithHashingStrategyTest::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableEmptyMapWithHashingStrategyTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableEmptyMapWithHashingStrategyTest::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableEmptyMapWithHashingStrategyTest::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableEmptyMapWithHashingStrategyTest::newWithoutKeys;
            this.payloads.castToMap = ImmutableEmptyMapWithHashingStrategyTest::castToMap;
            this.payloads.toMap = ImmutableEmptyMapWithHashingStrategyTest::toMap;
            this.payloads.entrySet = ImmutableEmptyMapWithHashingStrategyTest::entrySet;
            this.payloads.select = ImmutableEmptyMapWithHashingStrategyTest::select;
            this.payloads.reject = ImmutableEmptyMapWithHashingStrategyTest::reject;
            this.payloads.detect = ImmutableEmptyMapWithHashingStrategyTest::detect;
            this.payloads.collectValues = ImmutableEmptyMapWithHashingStrategyTest::collectValues;
            this.payloads.collect = ImmutableEmptyMapWithHashingStrategyTest::collect;
            this.payloads.appendString = ImmutableEmptyMapWithHashingStrategyTest::appendString;
            this.payloads.toBag = ImmutableEmptyMapWithHashingStrategyTest::toBag;
            this.payloads.asLazy = ImmutableEmptyMapWithHashingStrategyTest::asLazy;
            this.payloads.toList = ImmutableEmptyMapWithHashingStrategyTest::toList;
            this.payloads.toMapWithFunction = ImmutableEmptyMapWithHashingStrategyTest::toMapWithFunction;
            this.payloads.toSet = ImmutableEmptyMapWithHashingStrategyTest::toSet;
            this.payloads.toSortedList = ImmutableEmptyMapWithHashingStrategyTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableEmptyMapWithHashingStrategyTest::toSortedListBy;
            this.payloads.chunk = ImmutableEmptyMapWithHashingStrategyTest::chunk;
            this.payloads.collect_value = ImmutableEmptyMapWithHashingStrategyTest::collect_value;
            this.payloads.collectIf = ImmutableEmptyMapWithHashingStrategyTest::collectIf;
            this.payloads.collectWith = ImmutableEmptyMapWithHashingStrategyTest::collectWith;
            this.payloads.contains = ImmutableEmptyMapWithHashingStrategyTest::contains;
            this.payloads.getFirst = ImmutableEmptyMapWithHashingStrategyTest::getFirst;
            this.payloads.getLast = ImmutableEmptyMapWithHashingStrategyTest::getLast;
            this.payloads.containsAllIterable = ImmutableEmptyMapWithHashingStrategyTest::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableEmptyMapWithHashingStrategyTest::containsAllArguments;
            this.payloads.count = ImmutableEmptyMapWithHashingStrategyTest::count;
            this.payloads.detect_value = ImmutableEmptyMapWithHashingStrategyTest::detect_value;
            this.payloads.detectIfNone_value = ImmutableEmptyMapWithHashingStrategyTest::detectIfNone_value;
            this.payloads.flatCollect = ImmutableEmptyMapWithHashingStrategyTest::flatCollect;
            this.payloads.groupBy = ImmutableEmptyMapWithHashingStrategyTest::groupBy;
            this.payloads.groupByEach = ImmutableEmptyMapWithHashingStrategyTest::groupByEach;
            this.payloads.injectInto = ImmutableEmptyMapWithHashingStrategyTest::injectInto;
            this.payloads.makeString = ImmutableEmptyMapWithHashingStrategyTest::makeString;
            this.payloads.reject_value = ImmutableEmptyMapWithHashingStrategyTest::reject_value;
            this.payloads.rejectWith_value = ImmutableEmptyMapWithHashingStrategyTest::rejectWith_value;
            this.payloads.select_value = ImmutableEmptyMapWithHashingStrategyTest::select_value;
            this.payloads.selectWith_value = ImmutableEmptyMapWithHashingStrategyTest::selectWith_value;
            this.payloads.partition_value = ImmutableEmptyMapWithHashingStrategyTest::partition_value;
            this.payloads.partitionWith_value = ImmutableEmptyMapWithHashingStrategyTest::partitionWith_value;
            this.payloads.toArray = ImmutableEmptyMapWithHashingStrategyTest::toArray;
            this.payloads.zip = ImmutableEmptyMapWithHashingStrategyTest::zip;
            this.payloads.zipWithIndex = ImmutableEmptyMapWithHashingStrategyTest::zipWithIndex;
            this.payloads.testToString = ImmutableEmptyMapWithHashingStrategyTest::testToString;
            this.payloads.flipUniqueValues = ImmutableEmptyMapWithHashingStrategyTest::flipUniqueValues;
            this.payloads.get = ImmutableEmptyMapWithHashingStrategyTest::get;
            this.payloads.getIfAbsent_function = ImmutableEmptyMapWithHashingStrategyTest::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableEmptyMapWithHashingStrategyTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableEmptyMapWithHashingStrategyTest::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableEmptyMapWithHashingStrategyTest::getIfAbsentWith;
            this.payloads.ifPresentApply = ImmutableEmptyMapWithHashingStrategyTest::ifPresentApply;
            this.payloads.notEmpty = ImmutableEmptyMapWithHashingStrategyTest::notEmpty;
            this.payloads.allSatisfy = ImmutableEmptyMapWithHashingStrategyTest::allSatisfy;
            this.payloads.noneSatisfy = ImmutableEmptyMapWithHashingStrategyTest::noneSatisfy;
            this.payloads.anySatisfy = ImmutableEmptyMapWithHashingStrategyTest::anySatisfy;
            this.payloads.max = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyMapWithHashingStrategyTest::max, java.util.NoSuchElementException.class);
            this.payloads.maxBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyMapWithHashingStrategyTest::maxBy, java.util.NoSuchElementException.class);
            this.payloads.min = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyMapWithHashingStrategyTest::min, java.util.NoSuchElementException.class);
            this.payloads.minBy = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyMapWithHashingStrategyTest::minBy, java.util.NoSuchElementException.class);
            this.payloads.getOnly = new se.chalmers.ju2jmh.api.ExceptionTest<>(ImmutableEmptyMapWithHashingStrategyTest::getOnly, java.lang.IllegalStateException.class);
        }
    }
*/
}
