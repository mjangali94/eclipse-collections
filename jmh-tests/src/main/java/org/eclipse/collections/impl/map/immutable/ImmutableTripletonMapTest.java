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
import org.eclipse.collections.api.tuple.Pair;
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
 * JUnit test for {@link ImmutableTripletonMap}.
 */
public class ImmutableTripletonMapTest extends ImmutableMemoryEfficientMapTestCase {

    @Override
    protected ImmutableMap<Integer, String> classUnderTest() {
        return new ImmutableTripletonMap<>(1, "1", 2, "2", 3, "3");
    }

    @Override
    protected int size() {
        return 3;
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        ImmutableMap<Integer, String> map1 = new ImmutableTripletonMap<>(1, "One", 2, "Two", 3, "Three");
        ImmutableMap<Integer, String> map2 = new ImmutableTripletonMap<>(1, "One", 2, "Two", 3, "Three");
        Verify.assertEqualsAndHashCode(map1, map2);
    }

    @Override
    @Test
    public void forEachValue() {
        super.forEachValue();
        MutableList<String> collection = Lists.mutable.of();
        this.classUnderTest().forEachValue(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), collection);
    }

    @Override
    @Test
    public void forEachKey() {
        super.forEachKey();
        MutableList<Integer> collection = Lists.mutable.of();
        this.classUnderTest().forEachKey(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith(1, 2, 3), collection);
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
        Assert.assertEquals("3", map.ifPresentApply(3, Functions.getPassThru()));
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
        ImmutableMap<Integer, Integer> map = new ImmutableTripletonMap<>(1, 1, 2, 2, 3, 3);
        map.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 10);
        Assert.assertEquals(FastList.newListWith(11, 12, 13), result);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableTripletonMap<>(1, "One", 2, "Two", 3, "Three");
        map.forEachWithIndex((value, index) -> {
            result.add(value);
            result.add(String.valueOf(index));
        });
        Assert.assertEquals(FastList.newListWith("One", "0", "Two", "1", "Three", "2"), result);
    }

    @Override
    @Test
    public void keyValuesView() {
        super.keyValuesView();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableTripletonMap<>(1, "One", 2, "Two", 3, "Three");
        for (Pair<Integer, String> keyValue : map.keyValuesView()) {
            result.add(keyValue.getTwo());
        }
        Assert.assertEquals(FastList.newListWith("One", "Two", "Three"), result);
    }

    @Override
    @Test
    public void valuesView() {
        super.valuesView();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableTripletonMap<>(1, "One", 2, "Two", 3, "Three");
        for (String value : map.valuesView()) {
            result.add(value);
        }
        Assert.assertEquals(FastList.newListWith("One", "Two", "Three"), result);
    }

    @Override
    @Test
    public void keysView() {
        super.keysView();
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableTripletonMap<>(1, "One", 2, "Two", 3, "Three");
        for (Integer key : map.keysView()) {
            result.add(key);
        }
        Assert.assertEquals(FastList.newListWith(1, 2, 3), result);
    }

    @Override
    @Test
    public void testToString() {
        ImmutableMap<Integer, String> map = new ImmutableTripletonMap<>(1, "One", 2, "Two", 3, "Three");
        Assert.assertEquals("{1=One, 2=Two, 3=Three}", map.toString());
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
        Verify.assertInstanceOf(ImmutableTripletonMap.class, full);
        Assert.assertEquals(map, full);
        ImmutableMap<Integer, String> one = map.select((argument1, argument2) -> "1".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, one);
        Assert.assertEquals(new ImmutableSingletonMap<>(1, "1"), one);
        ImmutableMap<Integer, String> two = map.select((argument1, argument2) -> "2".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, two);
        Assert.assertEquals(new ImmutableSingletonMap<>(2, "2"), two);
        ImmutableMap<Integer, String> three = map.select((argument1, argument2) -> "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, three);
        Assert.assertEquals(new ImmutableSingletonMap<>(3, "3"), three);
        ImmutableMap<Integer, String> oneAndThree = map.select((argument1, argument2) -> "1".equals(argument2) || "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, oneAndThree);
        Assert.assertEquals(new ImmutableDoubletonMap<>(1, "1", 3, "3"), oneAndThree);
        ImmutableMap<Integer, String> oneAndTwo = map.select((argument1, argument2) -> "1".equals(argument2) || "2".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, oneAndTwo);
        Assert.assertEquals(new ImmutableDoubletonMap<>(1, "1", 2, "2"), oneAndTwo);
        ImmutableMap<Integer, String> twoAndThree = map.select((argument1, argument2) -> "2".equals(argument2) || "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, twoAndThree);
        Assert.assertEquals(new ImmutableDoubletonMap<>(2, "2", 3, "3"), twoAndThree);
    }

    @Override
    public void reject() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> empty = map.reject((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableEmptyMap.class, empty);
        ImmutableMap<Integer, String> full = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(ImmutableTripletonMap.class, full);
        Assert.assertEquals(map, full);
        ImmutableMap<Integer, String> one = map.reject((argument1, argument2) -> "2".equals(argument2) || "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, one);
        Assert.assertEquals(new ImmutableSingletonMap<>(1, "1"), one);
        ImmutableMap<Integer, String> two = map.reject((argument1, argument2) -> "1".equals(argument2) || "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, two);
        Assert.assertEquals(new ImmutableSingletonMap<>(2, "2"), two);
        ImmutableMap<Integer, String> three = map.reject((argument1, argument2) -> "1".equals(argument2) || "2".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, three);
        Assert.assertEquals(new ImmutableSingletonMap<>(3, "3"), three);
        ImmutableMap<Integer, String> oneAndThree = map.reject((argument1, argument2) -> "2".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, oneAndThree);
        Assert.assertEquals(new ImmutableDoubletonMap<>(1, "1", 3, "3"), oneAndThree);
        ImmutableMap<Integer, String> oneAndTwo = map.reject((argument1, argument2) -> "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, oneAndTwo);
        Assert.assertEquals(new ImmutableDoubletonMap<>(1, "1", 2, "2"), oneAndTwo);
        ImmutableMap<Integer, String> twoAndThree = map.reject((argument1, argument2) -> "1".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, twoAndThree);
        Assert.assertEquals(new ImmutableDoubletonMap<>(2, "2", 3, "3"), twoAndThree);
    }

    @Override
    public void detect() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Pair<Integer, String> one = map.detect((ignored1, ignored2) -> true);
        Assert.assertEquals(Tuples.pair(1, "1"), one);
        Pair<Integer, String> two = map.detect((argument1, argument2) -> "2".equals(argument2));
        Assert.assertEquals(Tuples.pair(2, "2"), two);
        Pair<Integer, String> three = map.detect((argument1, argument2) -> "3".equals(argument2));
        Assert.assertEquals(Tuples.pair(3, "3"), three);
        Assert.assertNull(map.detect((ignored1, ignored2) -> false));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableTripletonMap<>(key1, value1, key2, value2, key3, value3);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableTripletonMapTest instance;

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
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableTripletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> castToMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> toMapWithFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableTripletonMapTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEachKeyValue = ImmutableTripletonMapTest::forEachKeyValue;
            this.payloads.tap = ImmutableTripletonMapTest::tap;
            this.payloads.forEach = ImmutableTripletonMapTest::forEach;
            this.payloads.flipUniqueValues = ImmutableTripletonMapTest::flipUniqueValues;
            this.payloads.iterator = ImmutableTripletonMapTest::iterator;
            this.payloads.iteratorThrows = ImmutableTripletonMapTest::iteratorThrows;
            this.payloads.get = ImmutableTripletonMapTest::get;
            this.payloads.getIfAbsentWith = ImmutableTripletonMapTest::getIfAbsentWith;
            this.payloads.putAll = ImmutableTripletonMapTest::putAll;
            this.payloads.clear = ImmutableTripletonMapTest::clear;
            this.payloads.put = ImmutableTripletonMapTest::put;
            this.payloads.remove = ImmutableTripletonMapTest::remove;
            this.payloads.newWithKeyValue = ImmutableTripletonMapTest::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableTripletonMapTest::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableTripletonMapTest::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableTripletonMapTest::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableTripletonMapTest::withMapNull;
            this.payloads.newWithMapIterable = ImmutableTripletonMapTest::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableTripletonMapTest::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableTripletonMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableTripletonMapTest::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableTripletonMapTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableTripletonMapTest::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableTripletonMapTest::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableTripletonMapTest::newWithoutKeys;
            this.payloads.castToMap = ImmutableTripletonMapTest::castToMap;
            this.payloads.toMap = ImmutableTripletonMapTest::toMap;
            this.payloads.entrySet = ImmutableTripletonMapTest::entrySet;
            this.payloads.select = ImmutableTripletonMapTest::select;
            this.payloads.reject = ImmutableTripletonMapTest::reject;
            this.payloads.detect = ImmutableTripletonMapTest::detect;
            this.payloads.collectValues = ImmutableTripletonMapTest::collectValues;
            this.payloads.collect = ImmutableTripletonMapTest::collect;
            this.payloads.allSatisfy = ImmutableTripletonMapTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableTripletonMapTest::anySatisfy;
            this.payloads.noneSatisfy = ImmutableTripletonMapTest::noneSatisfy;
            this.payloads.appendString = ImmutableTripletonMapTest::appendString;
            this.payloads.toBag = ImmutableTripletonMapTest::toBag;
            this.payloads.asLazy = ImmutableTripletonMapTest::asLazy;
            this.payloads.toList = ImmutableTripletonMapTest::toList;
            this.payloads.toMapWithFunction = ImmutableTripletonMapTest::toMapWithFunction;
            this.payloads.toSet = ImmutableTripletonMapTest::toSet;
            this.payloads.toSortedList = ImmutableTripletonMapTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableTripletonMapTest::toSortedListBy;
            this.payloads.chunk = ImmutableTripletonMapTest::chunk;
            this.payloads.collect_value = ImmutableTripletonMapTest::collect_value;
            this.payloads.collectIf = ImmutableTripletonMapTest::collectIf;
            this.payloads.collectWith = ImmutableTripletonMapTest::collectWith;
            this.payloads.contains = ImmutableTripletonMapTest::contains;
            this.payloads.getFirst = ImmutableTripletonMapTest::getFirst;
            this.payloads.getLast = ImmutableTripletonMapTest::getLast;
            this.payloads.containsAllIterable = ImmutableTripletonMapTest::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableTripletonMapTest::containsAllArguments;
            this.payloads.count = ImmutableTripletonMapTest::count;
            this.payloads.detect_value = ImmutableTripletonMapTest::detect_value;
            this.payloads.detectIfNone_value = ImmutableTripletonMapTest::detectIfNone_value;
            this.payloads.flatCollect = ImmutableTripletonMapTest::flatCollect;
            this.payloads.groupBy = ImmutableTripletonMapTest::groupBy;
            this.payloads.groupByEach = ImmutableTripletonMapTest::groupByEach;
            this.payloads.injectInto = ImmutableTripletonMapTest::injectInto;
            this.payloads.makeString = ImmutableTripletonMapTest::makeString;
            this.payloads.min = ImmutableTripletonMapTest::min;
            this.payloads.max = ImmutableTripletonMapTest::max;
            this.payloads.minBy = ImmutableTripletonMapTest::minBy;
            this.payloads.maxBy = ImmutableTripletonMapTest::maxBy;
            this.payloads.reject_value = ImmutableTripletonMapTest::reject_value;
            this.payloads.rejectWith_value = ImmutableTripletonMapTest::rejectWith_value;
            this.payloads.select_value = ImmutableTripletonMapTest::select_value;
            this.payloads.selectWith_value = ImmutableTripletonMapTest::selectWith_value;
            this.payloads.partition_value = ImmutableTripletonMapTest::partition_value;
            this.payloads.partitionWith_value = ImmutableTripletonMapTest::partitionWith_value;
            this.payloads.toArray = ImmutableTripletonMapTest::toArray;
            this.payloads.zip = ImmutableTripletonMapTest::zip;
            this.payloads.zipWithIndex = ImmutableTripletonMapTest::zipWithIndex;
            this.payloads.equalsAndHashCode = ImmutableTripletonMapTest::equalsAndHashCode;
            this.payloads.forEachValue = ImmutableTripletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableTripletonMapTest::forEachKey;
            this.payloads.getIfAbsent_function = ImmutableTripletonMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableTripletonMapTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableTripletonMapTest::getIfAbsent;
            this.payloads.ifPresentApply = ImmutableTripletonMapTest::ifPresentApply;
            this.payloads.notEmpty = ImmutableTripletonMapTest::notEmpty;
            this.payloads.forEachWith = ImmutableTripletonMapTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableTripletonMapTest::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableTripletonMapTest::keyValuesView;
            this.payloads.valuesView = ImmutableTripletonMapTest::valuesView;
            this.payloads.keysView = ImmutableTripletonMapTest::keysView;
            this.payloads.testToString = ImmutableTripletonMapTest::testToString;
            this.payloads.getOnly = ImmutableTripletonMapTest::getOnly;
        }
    }
}
