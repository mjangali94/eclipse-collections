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
 * JUnit test for {@link ImmutableQuadrupletonMap}.
 */
public class ImmutableQuadrupletonMapTest extends ImmutableMemoryEfficientMapTestCase {

    @Override
    protected ImmutableMap<Integer, String> classUnderTest() {
        return new ImmutableQuadrupletonMap<>(1, "1", 2, "2", 3, "3", 4, "4");
    }

    @Override
    protected int size() {
        return 4;
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        ImmutableMap<Integer, String> map1 = new ImmutableQuadrupletonMap<>(1, "One", 2, "Two", 3, "Three", 4, "Four");
        ImmutableMap<Integer, String> map2 = new ImmutableQuadrupletonMap<>(1, "One", 2, "Two", 3, "Three", 4, "Four");
        Verify.assertEqualsAndHashCode(map1, map2);
    }

    @Override
    @Test
    public void forEachValue() {
        super.forEachValue();
        MutableList<String> collection = Lists.mutable.of();
        this.classUnderTest().forEachValue(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith("1", "2", "3", "4"), collection);
    }

    @Override
    @Test
    public void forEachKey() {
        super.forEachKey();
        MutableList<Integer> collection = Lists.mutable.of();
        this.classUnderTest().forEachKey(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), collection);
    }

    @Override
    @Test
    public void getIfAbsent_function() {
        super.getIfAbsent_function();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.get(5));
        Assert.assertEquals("5", map.getIfAbsent(5, new PassThruFunction0<>("5")));
        Assert.assertNull(map.get(5));
    }

    @Override
    @Test
    public void getOrDefault() {
        super.getOrDefault();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.get(5));
        Assert.assertEquals("5", map.getOrDefault(5, "5"));
        Assert.assertNull(map.get(5));
    }

    @Override
    @Test
    public void getIfAbsent() {
        super.getIfAbsent();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.get(5));
        Assert.assertEquals("5", map.getIfAbsentValue(5, "5"));
        Assert.assertNull(map.get(5));
    }

    @Override
    @Test
    public void ifPresentApply() {
        super.ifPresentApply();
        ImmutableMap<Integer, String> map = this.classUnderTest();
        Assert.assertNull(map.ifPresentApply(5, Functions.getPassThru()));
        Assert.assertEquals("1", map.ifPresentApply(1, Functions.getPassThru()));
        Assert.assertEquals("2", map.ifPresentApply(2, Functions.getPassThru()));
        Assert.assertEquals("3", map.ifPresentApply(3, Functions.getPassThru()));
        Assert.assertEquals("4", map.ifPresentApply(4, Functions.getPassThru()));
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
        ImmutableMap<Integer, Integer> map = new ImmutableQuadrupletonMap<>(1, 1, 2, 2, 3, 3, 4, 4);
        map.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 10);
        Assert.assertEquals(FastList.newListWith(11, 12, 13, 14), result);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableQuadrupletonMap<>(1, "One", 2, "Two", 3, "Three", 4, "Four");
        map.forEachWithIndex((value, index) -> {
            result.add(value);
            result.add(String.valueOf(index));
        });
        Assert.assertEquals(FastList.newListWith("One", "0", "Two", "1", "Three", "2", "Four", "3"), result);
    }

    @Override
    @Test
    public void keyValuesView() {
        super.keyValuesView();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableQuadrupletonMap<>(1, "One", 2, "Two", 3, "Three", 4, "Four");
        for (Pair<Integer, String> keyValue : map.keyValuesView()) {
            result.add(keyValue.getTwo());
        }
        Assert.assertEquals(FastList.newListWith("One", "Two", "Three", "Four"), result);
    }

    @Override
    @Test
    public void valuesView() {
        super.valuesView();
        MutableList<String> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableQuadrupletonMap<>(1, "One", 2, "Two", 3, "Three", 4, "Four");
        for (String value : map.valuesView()) {
            result.add(value);
        }
        Assert.assertEquals(FastList.newListWith("One", "Two", "Three", "Four"), result);
    }

    @Override
    @Test
    public void keysView() {
        super.keysView();
        MutableList<Integer> result = Lists.mutable.of();
        ImmutableMap<Integer, String> map = new ImmutableQuadrupletonMap<>(1, "One", 2, "Two", 3, "Three", 4, "Four");
        for (Integer key : map.keysView()) {
            result.add(key);
        }
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4), result);
    }

    @Override
    @Test
    public void testToString() {
        ImmutableMap<Integer, String> map = new ImmutableQuadrupletonMap<>(1, "One", 2, "Two", 3, "Three", 4, "Four");
        Assert.assertEquals("{1=One, 2=Two, 3=Three, 4=Four}", map.toString());
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
        Verify.assertInstanceOf(ImmutableQuadrupletonMap.class, full);
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
        ImmutableMap<Integer, String> four = map.select((argument1, argument2) -> "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, four);
        Assert.assertEquals(new ImmutableSingletonMap<>(4, "4"), four);
        ImmutableMap<Integer, String> oneAndFour = map.select((argument1, argument2) -> "1".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, oneAndFour);
        Assert.assertEquals(new ImmutableDoubletonMap<>(1, "1", 4, "4"), oneAndFour);
        ImmutableMap<Integer, String> oneAndThree = map.select((argument1, argument2) -> "1".equals(argument2) || "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, oneAndThree);
        Assert.assertEquals(new ImmutableDoubletonMap<>(1, "1", 3, "3"), oneAndThree);
        ImmutableMap<Integer, String> oneAndTwo = map.select((argument1, argument2) -> "1".equals(argument2) || "2".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, oneAndTwo);
        Assert.assertEquals(new ImmutableDoubletonMap<>(1, "1", 2, "2"), oneAndTwo);
        ImmutableMap<Integer, String> twoAndFour = map.select((argument1, argument2) -> "2".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, twoAndFour);
        Assert.assertEquals(new ImmutableDoubletonMap<>(2, "2", 4, "4"), twoAndFour);
        ImmutableMap<Integer, String> twoAndThree = map.select((argument1, argument2) -> "2".equals(argument2) || "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, twoAndThree);
        Assert.assertEquals(new ImmutableDoubletonMap<>(2, "2", 3, "3"), twoAndThree);
        ImmutableMap<Integer, String> threeAndFour = map.select((argument1, argument2) -> "3".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, threeAndFour);
        Assert.assertEquals(new ImmutableDoubletonMap<>(3, "3", 4, "4"), threeAndFour);
        ImmutableMap<Integer, String> twoThreeFour = map.select((argument1, argument2) -> "2".equals(argument2) || "3".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableTripletonMap.class, twoThreeFour);
        Assert.assertEquals(new ImmutableTripletonMap<>(2, "2", 3, "3", 4, "4"), twoThreeFour);
        ImmutableMap<Integer, String> oneThreeFour = map.select((argument1, argument2) -> "1".equals(argument2) || "3".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableTripletonMap.class, oneThreeFour);
        Assert.assertEquals(new ImmutableTripletonMap<>(1, "1", 3, "3", 4, "4"), oneThreeFour);
        ImmutableMap<Integer, String> oneTwoFour = map.select((argument1, argument2) -> "1".equals(argument2) || "2".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableTripletonMap.class, oneTwoFour);
        Assert.assertEquals(new ImmutableTripletonMap<>(1, "1", 2, "2", 4, "4"), oneTwoFour);
        ImmutableMap<Integer, String> oneTwoThree = map.select((argument1, argument2) -> "1".equals(argument2) || "2".equals(argument2) || "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableTripletonMap.class, oneTwoThree);
        Assert.assertEquals(new ImmutableTripletonMap<>(1, "1", 2, "2", 3, "3"), oneTwoThree);
    }

    @Override
    public void reject() {
        ImmutableMap<Integer, String> map = this.classUnderTest();
        ImmutableMap<Integer, String> empty = map.reject((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(ImmutableEmptyMap.class, empty);
        ImmutableMap<Integer, String> full = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(ImmutableQuadrupletonMap.class, full);
        Assert.assertEquals(map, full);
        ImmutableMap<Integer, String> one = map.reject((argument1, argument2) -> "2".equals(argument2) || "3".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, one);
        Assert.assertEquals(new ImmutableSingletonMap<>(1, "1"), one);
        ImmutableMap<Integer, String> two = map.reject((argument1, argument2) -> "1".equals(argument2) || "3".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, two);
        Assert.assertEquals(new ImmutableSingletonMap<>(2, "2"), two);
        ImmutableMap<Integer, String> three = map.reject((argument1, argument2) -> "1".equals(argument2) || "2".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, three);
        Assert.assertEquals(new ImmutableSingletonMap<>(3, "3"), three);
        ImmutableMap<Integer, String> four = map.reject((argument1, argument2) -> "1".equals(argument2) || "2".equals(argument2) || "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableSingletonMap.class, four);
        Assert.assertEquals(new ImmutableSingletonMap<>(4, "4"), four);
        ImmutableMap<Integer, String> oneAndFour = map.reject((argument1, argument2) -> "2".equals(argument2) || "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, oneAndFour);
        Assert.assertEquals(new ImmutableDoubletonMap<>(1, "1", 4, "4"), oneAndFour);
        ImmutableMap<Integer, String> oneAndThree = map.reject((argument1, argument2) -> "2".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, oneAndThree);
        Assert.assertEquals(new ImmutableDoubletonMap<>(1, "1", 3, "3"), oneAndThree);
        ImmutableMap<Integer, String> oneAndTwo = map.reject((argument1, argument2) -> "3".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, oneAndTwo);
        Assert.assertEquals(new ImmutableDoubletonMap<>(1, "1", 2, "2"), oneAndTwo);
        ImmutableMap<Integer, String> twoAndFour = map.reject((argument1, argument2) -> "1".equals(argument2) || "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, twoAndFour);
        Assert.assertEquals(new ImmutableDoubletonMap<>(2, "2", 4, "4"), twoAndFour);
        ImmutableMap<Integer, String> twoAndThree = map.reject((argument1, argument2) -> "1".equals(argument2) || "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, twoAndThree);
        Assert.assertEquals(new ImmutableDoubletonMap<>(2, "2", 3, "3"), twoAndThree);
        ImmutableMap<Integer, String> threeAndFour = map.reject((argument1, argument2) -> "1".equals(argument2) || "2".equals(argument2));
        Verify.assertInstanceOf(ImmutableDoubletonMap.class, threeAndFour);
        Assert.assertEquals(new ImmutableDoubletonMap<>(3, "3", 4, "4"), threeAndFour);
        ImmutableMap<Integer, String> twoThreeFour = map.reject((argument1, argument2) -> "1".equals(argument2));
        Verify.assertInstanceOf(ImmutableTripletonMap.class, twoThreeFour);
        Assert.assertEquals(new ImmutableTripletonMap<>(2, "2", 3, "3", 4, "4"), twoThreeFour);
        ImmutableMap<Integer, String> oneThreeFour = map.reject((argument1, argument2) -> "2".equals(argument2));
        Verify.assertInstanceOf(ImmutableTripletonMap.class, oneThreeFour);
        Assert.assertEquals(new ImmutableTripletonMap<>(1, "1", 3, "3", 4, "4"), oneThreeFour);
        ImmutableMap<Integer, String> oneTwoFour = map.reject((argument1, argument2) -> "3".equals(argument2));
        Verify.assertInstanceOf(ImmutableTripletonMap.class, oneTwoFour);
        Assert.assertEquals(new ImmutableTripletonMap<>(1, "1", 2, "2", 4, "4"), oneTwoFour);
        ImmutableMap<Integer, String> oneTwoThree = map.reject((argument1, argument2) -> "4".equals(argument2));
        Verify.assertInstanceOf(ImmutableTripletonMap.class, oneTwoThree);
        Assert.assertEquals(new ImmutableTripletonMap<>(1, "1", 2, "2", 3, "3"), oneTwoThree);
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
        Pair<Integer, String> four = map.detect((argument1, argument2) -> "4".equals(argument2));
        Assert.assertEquals(Tuples.pair(4, "4"), four);
        Assert.assertNull(map.detect((ignored1, ignored2) -> false));
    }

    @Override
    protected <K, V> ImmutableMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return new ImmutableQuadrupletonMap<>(key1, value1, key2, value2, key3, value3, key4, value4);
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private ImmutableQuadrupletonMapTest instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new ImmutableQuadrupletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> iteratorThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> get;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> putAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> put;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> newWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> newWithMap1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> newWithMapTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> newWithMapEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> withMapNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> newWithMapIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> newWithMapIterableTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> withMapIterableEmptyAndTargetEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> withMapIterableNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> newWithAllKeyValuePairs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> newWithAllKeyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> newWithoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> newWithoutKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> castToMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> toMapWithFunction;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> keyValuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> valuesView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> keysView;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<ImmutableQuadrupletonMapTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.forEachKeyValue = ImmutableQuadrupletonMapTest::forEachKeyValue;
            this.payloads.tap = ImmutableQuadrupletonMapTest::tap;
            this.payloads.forEach = ImmutableQuadrupletonMapTest::forEach;
            this.payloads.flipUniqueValues = ImmutableQuadrupletonMapTest::flipUniqueValues;
            this.payloads.iterator = ImmutableQuadrupletonMapTest::iterator;
            this.payloads.iteratorThrows = ImmutableQuadrupletonMapTest::iteratorThrows;
            this.payloads.get = ImmutableQuadrupletonMapTest::get;
            this.payloads.getIfAbsentWith = ImmutableQuadrupletonMapTest::getIfAbsentWith;
            this.payloads.putAll = ImmutableQuadrupletonMapTest::putAll;
            this.payloads.clear = ImmutableQuadrupletonMapTest::clear;
            this.payloads.put = ImmutableQuadrupletonMapTest::put;
            this.payloads.remove = ImmutableQuadrupletonMapTest::remove;
            this.payloads.newWithKeyValue = ImmutableQuadrupletonMapTest::newWithKeyValue;
            this.payloads.newWithMap1 = ImmutableQuadrupletonMapTest::newWithMap1;
            this.payloads.newWithMapTargetEmpty = ImmutableQuadrupletonMapTest::newWithMapTargetEmpty;
            this.payloads.newWithMapEmptyAndTargetEmpty = ImmutableQuadrupletonMapTest::newWithMapEmptyAndTargetEmpty;
            this.payloads.withMapNull = ImmutableQuadrupletonMapTest::withMapNull;
            this.payloads.newWithMapIterable = ImmutableQuadrupletonMapTest::newWithMapIterable;
            this.payloads.newWithMapIterableTargetEmpty = ImmutableQuadrupletonMapTest::newWithMapIterableTargetEmpty;
            this.payloads.withMapIterableEmptyAndTargetEmpty = ImmutableQuadrupletonMapTest::withMapIterableEmptyAndTargetEmpty;
            this.payloads.withMapIterableNull = ImmutableQuadrupletonMapTest::withMapIterableNull;
            this.payloads.newWithAllKeyValuePairs = ImmutableQuadrupletonMapTest::newWithAllKeyValuePairs;
            this.payloads.newWithAllKeyValues = ImmutableQuadrupletonMapTest::newWithAllKeyValues;
            this.payloads.newWithoutKey = ImmutableQuadrupletonMapTest::newWithoutKey;
            this.payloads.newWithoutKeys = ImmutableQuadrupletonMapTest::newWithoutKeys;
            this.payloads.castToMap = ImmutableQuadrupletonMapTest::castToMap;
            this.payloads.toMap = ImmutableQuadrupletonMapTest::toMap;
            this.payloads.entrySet = ImmutableQuadrupletonMapTest::entrySet;
            this.payloads.select = ImmutableQuadrupletonMapTest::select;
            this.payloads.reject = ImmutableQuadrupletonMapTest::reject;
            this.payloads.detect = ImmutableQuadrupletonMapTest::detect;
            this.payloads.collectValues = ImmutableQuadrupletonMapTest::collectValues;
            this.payloads.collect = ImmutableQuadrupletonMapTest::collect;
            this.payloads.allSatisfy = ImmutableQuadrupletonMapTest::allSatisfy;
            this.payloads.anySatisfy = ImmutableQuadrupletonMapTest::anySatisfy;
            this.payloads.noneSatisfy = ImmutableQuadrupletonMapTest::noneSatisfy;
            this.payloads.appendString = ImmutableQuadrupletonMapTest::appendString;
            this.payloads.toBag = ImmutableQuadrupletonMapTest::toBag;
            this.payloads.asLazy = ImmutableQuadrupletonMapTest::asLazy;
            this.payloads.toList = ImmutableQuadrupletonMapTest::toList;
            this.payloads.toMapWithFunction = ImmutableQuadrupletonMapTest::toMapWithFunction;
            this.payloads.toSet = ImmutableQuadrupletonMapTest::toSet;
            this.payloads.toSortedList = ImmutableQuadrupletonMapTest::toSortedList;
            this.payloads.toSortedListBy = ImmutableQuadrupletonMapTest::toSortedListBy;
            this.payloads.chunk = ImmutableQuadrupletonMapTest::chunk;
            this.payloads.collect_value = ImmutableQuadrupletonMapTest::collect_value;
            this.payloads.collectIf = ImmutableQuadrupletonMapTest::collectIf;
            this.payloads.collectWith = ImmutableQuadrupletonMapTest::collectWith;
            this.payloads.contains = ImmutableQuadrupletonMapTest::contains;
            this.payloads.getFirst = ImmutableQuadrupletonMapTest::getFirst;
            this.payloads.getLast = ImmutableQuadrupletonMapTest::getLast;
            this.payloads.containsAllIterable = ImmutableQuadrupletonMapTest::containsAllIterable;
            this.payloads.containsAllArguments = ImmutableQuadrupletonMapTest::containsAllArguments;
            this.payloads.count = ImmutableQuadrupletonMapTest::count;
            this.payloads.detect_value = ImmutableQuadrupletonMapTest::detect_value;
            this.payloads.detectIfNone_value = ImmutableQuadrupletonMapTest::detectIfNone_value;
            this.payloads.flatCollect = ImmutableQuadrupletonMapTest::flatCollect;
            this.payloads.groupBy = ImmutableQuadrupletonMapTest::groupBy;
            this.payloads.groupByEach = ImmutableQuadrupletonMapTest::groupByEach;
            this.payloads.injectInto = ImmutableQuadrupletonMapTest::injectInto;
            this.payloads.makeString = ImmutableQuadrupletonMapTest::makeString;
            this.payloads.min = ImmutableQuadrupletonMapTest::min;
            this.payloads.max = ImmutableQuadrupletonMapTest::max;
            this.payloads.minBy = ImmutableQuadrupletonMapTest::minBy;
            this.payloads.maxBy = ImmutableQuadrupletonMapTest::maxBy;
            this.payloads.reject_value = ImmutableQuadrupletonMapTest::reject_value;
            this.payloads.rejectWith_value = ImmutableQuadrupletonMapTest::rejectWith_value;
            this.payloads.select_value = ImmutableQuadrupletonMapTest::select_value;
            this.payloads.selectWith_value = ImmutableQuadrupletonMapTest::selectWith_value;
            this.payloads.partition_value = ImmutableQuadrupletonMapTest::partition_value;
            this.payloads.partitionWith_value = ImmutableQuadrupletonMapTest::partitionWith_value;
            this.payloads.toArray = ImmutableQuadrupletonMapTest::toArray;
            this.payloads.zip = ImmutableQuadrupletonMapTest::zip;
            this.payloads.zipWithIndex = ImmutableQuadrupletonMapTest::zipWithIndex;
            this.payloads.equalsAndHashCode = ImmutableQuadrupletonMapTest::equalsAndHashCode;
            this.payloads.forEachValue = ImmutableQuadrupletonMapTest::forEachValue;
            this.payloads.forEachKey = ImmutableQuadrupletonMapTest::forEachKey;
            this.payloads.getIfAbsent_function = ImmutableQuadrupletonMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = ImmutableQuadrupletonMapTest::getOrDefault;
            this.payloads.getIfAbsent = ImmutableQuadrupletonMapTest::getIfAbsent;
            this.payloads.ifPresentApply = ImmutableQuadrupletonMapTest::ifPresentApply;
            this.payloads.notEmpty = ImmutableQuadrupletonMapTest::notEmpty;
            this.payloads.forEachWith = ImmutableQuadrupletonMapTest::forEachWith;
            this.payloads.forEachWithIndex = ImmutableQuadrupletonMapTest::forEachWithIndex;
            this.payloads.keyValuesView = ImmutableQuadrupletonMapTest::keyValuesView;
            this.payloads.valuesView = ImmutableQuadrupletonMapTest::valuesView;
            this.payloads.keysView = ImmutableQuadrupletonMapTest::keysView;
            this.payloads.testToString = ImmutableQuadrupletonMapTest::testToString;
            this.payloads.getOnly = ImmutableQuadrupletonMapTest::getOnly;
        }
    }
*/
}
