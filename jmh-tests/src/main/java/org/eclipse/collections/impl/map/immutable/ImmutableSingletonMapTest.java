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

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableSingletonMap}.
 */
public class ImmutableSingletonMapTest extends ImmutableMemoryEfficientMapTestCase {

    @Override
    protected ImmutableMap<Integer, String> classUnderTest() {
        return new ImmutableSingletonMap<>(1, "1");
    }

    @Override
    protected int size() {
        return 1;
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        ImmutableMap<Integer, String> map1 = new ImmutableSingletonMap<>(1, "One");
        ImmutableMap<Integer, String> map2 = new ImmutableSingletonMap<>(1, "One");
        Verify.assertEqualsAndHashCode(map1, map2);
    }

    @Test
    public void equalsAndHashCodeWithNulls() {
        ImmutableMap<Integer, String> map1 = new ImmutableSingletonMap<>(null, null);
        MutableMap<Integer, String> map2 = Maps.fixedSize.of(null, null);
        Verify.assertEqualsAndHashCode(map1, map2);
    }

    @Override
    @Test
    public void forEachValue() {
        super.forEachValue();
        MutableList<String> collection = Lists.mutable.of();
        this.classUnderTest().forEachValue(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith("1"), collection);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        MutableList<String> collection = Lists.mutable.of();
        this.classUnderTest().forEach(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith("1"), collection);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableList<String> collection = Lists.mutable.of();
        for (String eachValue : this.classUnderTest()) {
            collection.add(eachValue);
        }
        Assert.assertEquals(FastList.newListWith("1"), collection);
    }

    @Override
    @Test
    public void forEachKey() {
        super.forEachKey();
        MutableList<Integer> collection = Lists.mutable.of();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        map.forEachKey(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith(1), collection);
    }

    @Override
    @Test
    public void getIfAbsent_function() {
        super.getIfAbsent_function();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsent(4, new PassThruFunction0<>("4")));
        Assert.assertEquals("1", map.getIfAbsent(1, new PassThruFunction0<>("1")));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1"), map);
    }

    @Override
    @Test
    public void getOrDefault() {
        super.getOrDefault();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getOrDefault(4, "4"));
        Assert.assertEquals("1", map.getOrDefault(1, "1"));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1"), map);
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsentValue(4, "4"));
        Assert.assertEquals("1", map.getIfAbsentValue(1, "1"));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1"), map);
    }

    @Override
    @Test
    public void getIfAbsentWith() {
        super.getIfAbsentWith();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsentWith(4, String::valueOf, 4));
        Assert.assertEquals("1", map.getIfAbsentWith(1, String::valueOf, 1));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1"), map);
    }

    @Override
    @Test
    public void ifPresentApply() {
        super.ifPresentApply();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.ifPresentApply(4, Functions.getPassThru()));
        Assert.assertEquals("1", map.ifPresentApply(1, Functions.getPassThru()));
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
        ImmutableMap<Integer, Integer> map = new ImmutableSingletonMap<>(1, 1);
        map.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 10);
        Assert.assertEquals(FastList.newListWith(11), result);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableSingletonMap<>(1, "One");
        map.forEachWithIndex((value, index) -> {
            result.add(value);
            result.add(String.valueOf(index));
        });
        Assert.assertEquals(FastList.newListWith("One", "0"), result);
    }

    @Override
    @Test
    public void keyValuesView() {
        super.keyValuesView();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableSingletonMap<>(1, "One");
        for (Pair<Integer, String> entry : map.keyValuesView()) {
            result.add(entry.getTwo());
        }
        Assert.assertEquals(FastList.newListWith("One"), result);
    }

    @Override
    @Test
    public void valuesView() {
        super.valuesView();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableSingletonMap<>(1, "One");
        for (String value : map.valuesView()) {
            result.add(value);
        }
        Assert.assertEquals(FastList.newListWith("One"), result);
    }

    @Override
    @Test
    public void keysView() {
        super.keysView();
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableSingletonMap<>(1, "One");
        for (Integer key : map.keysView()) {
            result.add(key);
        }
        Assert.assertEquals(FastList.newListWith(1), result);
    }

    @Override
    @Test
    public void testToString() {
        ImmutableMap<Integer, String> map = new ImmutableSingletonMap<>(1, "One");
        Assert.assertEquals("{1=One}", map.toString());
    }

    @Test
    public void asLazyKeys() {
        MutableList<Integer> keys = Maps.fixedSize.of(1, 1).keysView().toSortedList();
        Assert.assertEquals(FastList.newListWith(1), keys);
    }

    @Test
    public void asLazyValues() {
        MutableList<Integer> values = Maps.fixedSize.of(1, 1).valuesView().toSortedList();
        Assert.assertEquals(FastList.newListWith(1), values);
    }

    @Test
    public void getOnly() {
        ImmutableSingletonMap<Integer, String> singletonMap = new ImmutableSingletonMap<>(1, "One");
        Assert.assertEquals("One", singletonMap.getOnly());
    }

    @Override
    public void select() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> empty = map.select((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(ImmutableEmptyMap.class, empty);
        ImmutableMap<Integer, String> full = map.select((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableSingletonMap.class, full);
        Assert.assertEquals(map, full);
    }

    @Override
    public void reject() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> empty = map.reject((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableEmptyMap.class, empty);
        Assert.assertEquals(new ImmutableEmptyMap<Integer, String>(), empty);
        ImmutableMap<Integer, String> full = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(ImmutableSingletonMap.class, full);
        Assert.assertEquals(map, full);
    }

    @Override
    public void detect() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Pair<Integer, String> actual = map.detect((ignored1, ignored2) -> true);
        Assert.assertEquals(Tuples.pair(1, "1"), actual);
        Assert.assertNull(map.detect((ignored1, ignored2) -> false));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableSingletonMap<>(key1, value1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableSingletonMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorThrows);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_get() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.get);
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
        public void benchmark_min() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCodeWithNulls() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCodeWithNulls);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
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
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazyKeys);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazyValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableSingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> castToMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> toMapWithFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> equalsAndHashCodeWithNulls;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> asLazyKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> asLazyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableSingletonMapTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEachKeyValue = ImmutableSingletonMapTest::forEachKeyValue;
            this.payloads.tap = ImmutableSingletonMapTest::tap;
            this.payloads.flipUniqueValues = ImmutableSingletonMapTest::flipUniqueValues;
            this.payloads.iteratorThrows = ImmutableSingletonMapTest::iteratorThrows;
            this.payloads.get = ImmutableSingletonMapTest::get;
            this.payloads.putAll = ImmutableSingletonMapTest::putAll;
            this.payloads.clear = ImmutableSingletonMapTest::clear;
            this.payloads.put = ImmutableSingletonMapTest::put;
            this.payloads.remove = ImmutableSingletonMapTest::remove;
            this.payloads.newWithKeyValue = ImmutableSingletonMapTest::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableSingletonMapTest::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableSingletonMapTest::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableSingletonMapTest::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableSingletonMapTest::withMapNull;
            this.payloads.newWithMapIterable = ImmutableSingletonMapTest::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableSingletonMapTest::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableSingletonMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableSingletonMapTest::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableSingletonMapTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableSingletonMapTest::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableSingletonMapTest::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableSingletonMapTest::newWithoutKeys;
            this.payloads.castToMap = ImmutableSingletonMapTest::castToMap;
            this.payloads.toMap = ImmutableSingletonMapTest::toMap;
            this.payloads.entrySet = ImmutableSingletonMapTest::entrySet;
            this.payloads.select = ImmutableSingletonMapTest::select;
            this.payloads.reject = ImmutableSingletonMapTest::reject;
            this.payloads.detect = ImmutableSingletonMapTest::detect;
            this.payloads.collectValues = ImmutableSingletonMapTest::collectValues;
            this.payloads.collect = ImmutableSingletonMapTest::collect;
            this.payloads.allSatisfy = ImmutableSingletonMapTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableSingletonMapTest::anySatisfy;
            this.payloads.noneSatisfy = ImmutableSingletonMapTest::noneSatisfy;
            this.payloads.appendString = ImmutableSingletonMapTest::appendString;
            this.payloads.toBag = ImmutableSingletonMapTest::toBag;
            this.payloads.asLazy = ImmutableSingletonMapTest::asLazy;
            this.payloads.toList = ImmutableSingletonMapTest::toList;
            this.payloads.toMapWithFunction = ImmutableSingletonMapTest::toMapWithFunction;
            this.payloads.toSet = ImmutableSingletonMapTest::toSet;
            this.payloads.toSortedList = ImmutableSingletonMapTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableSingletonMapTest::toSortedListBy;
            this.payloads.chunk = ImmutableSingletonMapTest::chunk;
            this.payloads.collect_value = ImmutableSingletonMapTest::collect_value;
            this.payloads.collectIf = ImmutableSingletonMapTest::collectIf;
            this.payloads.collectWith = ImmutableSingletonMapTest::collectWith;
            this.payloads.contains = ImmutableSingletonMapTest::contains;
            this.payloads.getFirst = ImmutableSingletonMapTest::getFirst;
            this.payloads.getLast = ImmutableSingletonMapTest::getLast;
            this.payloads.containsAllIterable = ImmutableSingletonMapTest::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableSingletonMapTest::containsAllArguments;
            this.payloads.count = ImmutableSingletonMapTest::count;
            this.payloads.detect_value = ImmutableSingletonMapTest::detect_value;
            this.payloads.detectIfNone_value = ImmutableSingletonMapTest::detectIfNone_value;
            this.payloads.flatCollect = ImmutableSingletonMapTest::flatCollect;
            this.payloads.groupBy = ImmutableSingletonMapTest::groupBy;
            this.payloads.groupByEach = ImmutableSingletonMapTest::groupByEach;
            this.payloads.injectInto = ImmutableSingletonMapTest::injectInto;
            this.payloads.makeString = ImmutableSingletonMapTest::makeString;
            this.payloads.min = ImmutableSingletonMapTest::min;
            this.payloads.max = ImmutableSingletonMapTest::max;
            this.payloads.minBy = ImmutableSingletonMapTest::minBy;
            this.payloads.maxBy = ImmutableSingletonMapTest::maxBy;
            this.payloads.reject_value = ImmutableSingletonMapTest::reject_value;
            this.payloads.rejectWith_value = ImmutableSingletonMapTest::rejectWith_value;
            this.payloads.select_value = ImmutableSingletonMapTest::select_value;
            this.payloads.selectWith_value = ImmutableSingletonMapTest::selectWith_value;
            this.payloads.partition_value = ImmutableSingletonMapTest::partition_value;
            this.payloads.partitionWith_value = ImmutableSingletonMapTest::partitionWith_value;
            this.payloads.toArray = ImmutableSingletonMapTest::toArray;
            this.payloads.zip = ImmutableSingletonMapTest::zip;
            this.payloads.zipWithIndex = ImmutableSingletonMapTest::zipWithIndex;
            this.payloads.equalsAndHashCode = ImmutableSingletonMapTest::equalsAndHashCode;
            this.payloads.equalsAndHashCodeWithNulls = ImmutableSingletonMapTest::equalsAndHashCodeWithNulls;
            this.payloads.forEachValue = ImmutableSingletonMapTest::forEachValue;
            this.payloads.forEach = ImmutableSingletonMapTest::forEach;
            this.payloads.iterator = ImmutableSingletonMapTest::iterator;
            this.payloads.forEachKey = ImmutableSingletonMapTest::forEachKey;
            this.payloads.getIfAbsent_function = ImmutableSingletonMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableSingletonMapTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableSingletonMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = ImmutableSingletonMapTest::getIfAbsentWith;
            this.payloads.ifPresentApply = ImmutableSingletonMapTest::ifPresentApply;
            this.payloads.notEmpty = ImmutableSingletonMapTest::notEmpty;
            this.payloads.forEachWith = ImmutableSingletonMapTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableSingletonMapTest::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableSingletonMapTest::keyValuesView;
            this.payloads.valuesView = ImmutableSingletonMapTest::valuesView;
            this.payloads.keysView = ImmutableSingletonMapTest::keysView;
            this.payloads.testToString = ImmutableSingletonMapTest::testToString;
            this.payloads.asLazyKeys = ImmutableSingletonMapTest::asLazyKeys;
            this.payloads.asLazyValues = ImmutableSingletonMapTest::asLazyValues;
            this.payloads.getOnly = ImmutableSingletonMapTest::getOnly;
        }
    }
}
