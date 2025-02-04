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

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubletonMap}.
 */
public class ImmutableDoubletonMapTest extends ImmutableMemoryEfficientMapTestCase {

    @Override
    protected ImmutableMap<Integer, String> classUnderTest() {
        return new ImmutableDoubletonMap<>(1, "1", 2, "2");
    }

    @Override
    protected int size() {
        return 2;
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        ImmutableMap<Integer, String> map1 = new ImmutableDoubletonMap<>(1, "One", 2, "Two");
        ImmutableMap<Integer, String> map2 = new ImmutableDoubletonMap<>(1, "One", 2, "Two");
        Verify.assertEqualsAndHashCode(map1, map2);
    }

    @Override
    @Test
    public void forEachValue() {
        super.forEachValue();
        MutableList<String> collection = Lists.mutable.of();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        map.forEachValue(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith("1", "2"), collection);
    }

    @Override
    @Test
    public void forEachKey() {
        super.forEachKey();
        MutableList<Integer> collection = Lists.mutable.of();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        map.forEachKey(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith(1, 2), collection);
    }

    @Override
    @Test
    public void getIfAbsent_function() {
        super.getIfAbsent_function();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsent(4, new PassThruFunction0<>("4")));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void getOrDefault() {
        super.getOrDefault();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getOrDefault(4, "4"));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsentValue(4, "4"));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void ifPresentApply() {
        super.ifPresentApply();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.ifPresentApply(4, Functions.getPassThru()));
        Assert.assertEquals("1", map.ifPresentApply(1, Functions.getPassThru()));
        Assert.assertEquals("2", map.ifPresentApply(2, Functions.getPassThru()));
    }

    @Override
    @Test
    public void notEmpty() {
        super.notEmpty();
        Assert.assertTrue(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void forEachWith() {
        super.forEachWith();
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableMap<Integer, Integer> map = new ImmutableDoubletonMap<>(1, 1, 2, 2);
        map.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 10);
        Assert.assertEquals(FastList.newListWith(11, 12), result);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableDoubletonMap<>(1, "One", 2, "Two");
        map.forEachWithIndex((value, index) -> {
            result.add(value);
            result.add(String.valueOf(index));
        });
        Assert.assertEquals(FastList.newListWith("One", "0", "Two", "1"), result);
    }

    @Override
    @Test
    public void keyValuesView() {
        super.keyValuesView();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableDoubletonMap<>(1, "One", 2, "Two");
        for (Pair<Integer, String> entry : map.keyValuesView()) {
            result.add(entry.getTwo());
        }
        Assert.assertEquals(FastList.newListWith("One", "Two"), result);
    }

    @Override
    @Test
    public void valuesView() {
        super.valuesView();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableDoubletonMap<>(1, "One", 2, "Two");
        for (String value : map.valuesView()) {
            result.add(value);
        }
        Assert.assertEquals(FastList.newListWith("One", "Two"), result);
    }

    @Override
    @Test
    public void keysView() {
        super.keysView();
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableDoubletonMap<>(1, "One", 2, "Two");
        for (Integer key : map.keysView()) {
            result.add(key);
        }
        Assert.assertEquals(FastList.newListWith(1, 2), result);
    }

    @Override
    @Test
    public void testToString() {
        ImmutableMap<Integer, String> map = new ImmutableDoubletonMap<>(1, "One", 2, "Two");
        Assert.assertEquals("{1=One, 2=Two}", map.toString());
    }

    @Test
    public void asLazyKeys() {
        MutableList<Integer> keys = new ImmutableDoubletonMap<>(1, 1, 2, 2).keysView().toSortedList();
        Assert.assertEquals(FastList.newListWith(1, 2), keys);
    }

    @Test
    public void asLazyValues() {
        MutableList<Integer> values = new ImmutableDoubletonMap<>(1, 1, 2, 2).valuesView().toSortedList();
        Assert.assertEquals(FastList.newListWith(1, 2), values);
    }

    @Test
    public void asLazyEntries() {
        MutableList<Pair<Integer, Integer>> values = new ImmutableDoubletonMap<>(1, 1, 2, 2).keyValuesView().toSortedList(Comparators.byFunction((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Assert.assertEquals(FastList.newListWith(Tuples.pair(1, 1), Tuples.pair(2, 2)), values);
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
    }

    @Override
    public void select() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> empty = map.select((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(ImmutableEmptyMap.class, empty);
        ImmutableMap<Integer, String> full = map.select((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, full);
        Assert.assertEquals(map, full);
        ImmutableMap<Integer, String> one = map.select((argument1, argument2) -> "1".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, one);
        Assert.assertEquals(new ImmutableSingletonMap<>(1, "1"), one);
        ImmutableMap<Integer, String> two = map.select((argument1, argument2) -> "2".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, two);
        Assert.assertEquals(new ImmutableSingletonMap<>(2, "2"), two);
    }

    @Override
    public void reject() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> empty = map.reject((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableEmptyMap.class, empty);
        ImmutableMap<Integer, String> full = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, full);
        Assert.assertEquals(map, full);
        ImmutableMap<Integer, String> one = map.reject((argument1, argument2) -> "2".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, one);
        Assert.assertEquals(new ImmutableSingletonMap<>(1, "1"), one);
        ImmutableMap<Integer, String> two = map.reject((argument1, argument2) -> "1".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, two);
        Assert.assertEquals(new ImmutableSingletonMap<>(2, "2"), two);
    }

    @Override
    public void detect() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Pair<Integer, String> one = map.detect((ignored1, ignored2) -> true);
        Assert.assertEquals(Tuples.pair(1, "1"), one);
        Pair<Integer, String> two = map.detect((argument1, argument2) -> "2".equals(argument2));
        Assert.assertEquals(Tuples.pair(2, "2"), two);
        Assert.assertNull(map.detect((ignored1, ignored2) -> false));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableDoubletonMap<>(key1, value1, key2, value2);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableDoubletonMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
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
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentWith);
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
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazyKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazyValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyEntries() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazyEntries);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableDoubletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> castToMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> toMapWithFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> asLazyKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> asLazyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> asLazyEntries;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableDoubletonMapTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEachKeyValue = ImmutableDoubletonMapTest::forEachKeyValue;
            this.payloads.tap = ImmutableDoubletonMapTest::tap;
            this.payloads.forEach = ImmutableDoubletonMapTest::forEach;
            this.payloads.flipUniqueValues = ImmutableDoubletonMapTest::flipUniqueValues;
            this.payloads.iterator = ImmutableDoubletonMapTest::iterator;
            this.payloads.iteratorThrows = ImmutableDoubletonMapTest::iteratorThrows;
            this.payloads.get = ImmutableDoubletonMapTest::get;
            this.payloads.getIfAbsentWith = ImmutableDoubletonMapTest::getIfAbsentWith;
            this.payloads.putAll = ImmutableDoubletonMapTest::putAll;
            this.payloads.clear = ImmutableDoubletonMapTest::clear;
            this.payloads.put = ImmutableDoubletonMapTest::put;
            this.payloads.remove = ImmutableDoubletonMapTest::remove;
            this.payloads.newWithKeyValue = ImmutableDoubletonMapTest::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableDoubletonMapTest::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableDoubletonMapTest::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableDoubletonMapTest::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableDoubletonMapTest::withMapNull;
            this.payloads.newWithMapIterable = ImmutableDoubletonMapTest::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableDoubletonMapTest::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableDoubletonMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableDoubletonMapTest::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableDoubletonMapTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableDoubletonMapTest::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableDoubletonMapTest::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableDoubletonMapTest::newWithoutKeys;
            this.payloads.castToMap = ImmutableDoubletonMapTest::castToMap;
            this.payloads.toMap = ImmutableDoubletonMapTest::toMap;
            this.payloads.entrySet = ImmutableDoubletonMapTest::entrySet;
            this.payloads.select = ImmutableDoubletonMapTest::select;
            this.payloads.reject = ImmutableDoubletonMapTest::reject;
            this.payloads.detect = ImmutableDoubletonMapTest::detect;
            this.payloads.collectValues = ImmutableDoubletonMapTest::collectValues;
            this.payloads.collect = ImmutableDoubletonMapTest::collect;
            this.payloads.allSatisfy = ImmutableDoubletonMapTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableDoubletonMapTest::anySatisfy;
            this.payloads.noneSatisfy = ImmutableDoubletonMapTest::noneSatisfy;
            this.payloads.appendString = ImmutableDoubletonMapTest::appendString;
            this.payloads.toBag = ImmutableDoubletonMapTest::toBag;
            this.payloads.asLazy = ImmutableDoubletonMapTest::asLazy;
            this.payloads.toList = ImmutableDoubletonMapTest::toList;
            this.payloads.toMapWithFunction = ImmutableDoubletonMapTest::toMapWithFunction;
            this.payloads.toSet = ImmutableDoubletonMapTest::toSet;
            this.payloads.toSortedList = ImmutableDoubletonMapTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableDoubletonMapTest::toSortedListBy;
            this.payloads.chunk = ImmutableDoubletonMapTest::chunk;
            this.payloads.collect_value = ImmutableDoubletonMapTest::collect_value;
            this.payloads.collectIf = ImmutableDoubletonMapTest::collectIf;
            this.payloads.collectWith = ImmutableDoubletonMapTest::collectWith;
            this.payloads.contains = ImmutableDoubletonMapTest::contains;
            this.payloads.getFirst = ImmutableDoubletonMapTest::getFirst;
            this.payloads.getLast = ImmutableDoubletonMapTest::getLast;
            this.payloads.containsAllIterable = ImmutableDoubletonMapTest::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableDoubletonMapTest::containsAllArguments;
            this.payloads.count = ImmutableDoubletonMapTest::count;
            this.payloads.detect_value = ImmutableDoubletonMapTest::detect_value;
            this.payloads.detectIfNone_value = ImmutableDoubletonMapTest::detectIfNone_value;
            this.payloads.flatCollect = ImmutableDoubletonMapTest::flatCollect;
            this.payloads.groupBy = ImmutableDoubletonMapTest::groupBy;
            this.payloads.groupByEach = ImmutableDoubletonMapTest::groupByEach;
            this.payloads.injectInto = ImmutableDoubletonMapTest::injectInto;
            this.payloads.makeString = ImmutableDoubletonMapTest::makeString;
            this.payloads.min = ImmutableDoubletonMapTest::min;
            this.payloads.max = ImmutableDoubletonMapTest::max;
            this.payloads.minBy = ImmutableDoubletonMapTest::minBy;
            this.payloads.maxBy = ImmutableDoubletonMapTest::maxBy;
            this.payloads.reject_value = ImmutableDoubletonMapTest::reject_value;
            this.payloads.rejectWith_value = ImmutableDoubletonMapTest::rejectWith_value;
            this.payloads.select_value = ImmutableDoubletonMapTest::select_value;
            this.payloads.selectWith_value = ImmutableDoubletonMapTest::selectWith_value;
            this.payloads.partition_value = ImmutableDoubletonMapTest::partition_value;
            this.payloads.partitionWith_value = ImmutableDoubletonMapTest::partitionWith_value;
            this.payloads.toArray = ImmutableDoubletonMapTest::toArray;
            this.payloads.zip = ImmutableDoubletonMapTest::zip;
            this.payloads.zipWithIndex = ImmutableDoubletonMapTest::zipWithIndex;
            this.payloads.equalsAndHashCode = ImmutableDoubletonMapTest::equalsAndHashCode;
            this.payloads.forEachValue = ImmutableDoubletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableDoubletonMapTest::forEachKey;
            this.payloads.getIfAbsent_function = ImmutableDoubletonMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableDoubletonMapTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableDoubletonMapTest::getIfAbsent;
            this.payloads.ifPresentApply = ImmutableDoubletonMapTest::ifPresentApply;
            this.payloads.notEmpty = ImmutableDoubletonMapTest::notEmpty;
            this.payloads.forEachWith = ImmutableDoubletonMapTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableDoubletonMapTest::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableDoubletonMapTest::keyValuesView;
            this.payloads.valuesView = ImmutableDoubletonMapTest::valuesView;
            this.payloads.keysView = ImmutableDoubletonMapTest::keysView;
            this.payloads.testToString = ImmutableDoubletonMapTest::testToString;
            this.payloads.asLazyKeys = ImmutableDoubletonMapTest::asLazyKeys;
            this.payloads.asLazyValues = ImmutableDoubletonMapTest::asLazyValues;
            this.payloads.asLazyEntries = ImmutableDoubletonMapTest::asLazyEntries;
            this.payloads.getOnly = ImmutableDoubletonMapTest::getOnly;
        }
    }
}
