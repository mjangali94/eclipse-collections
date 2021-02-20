/*
 * Copyright (c) 2017 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.fixed;

import java.util.Map;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.FixedSizeMap;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.Twin;
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
 * JUnit test for {@link DoubletonMap}.
 */
public class DoubletonMapTest extends AbstractMemoryEfficientMutableMapTest {

    @Override
    protected MutableMap<String, String> classUnderTest() {
        return new DoubletonMap<>("1", "One", "2", "Two");
    }

    @Override
    protected MutableMap<String, Integer> mixedTypeClassUnderTest() {
        return new DoubletonMap<>("1", 1, "Two", 2);
    }

    @Override
    @Test
    public void containsValue() {
        Assert.assertTrue(this.classUnderTest().containsValue("One"));
    }

    @Override
    @Test
    public void forEachKeyValue() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "One", 2, "Two");
        map.forEachKeyValue((key, value) -> collection.add(key + value));
        Assert.assertEquals(FastList.newListWith("1One", "2Two"), collection);
    }

    @Test
    public void flipUniqueValues() {
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "One", 2, "Two");
        MutableMap<String, Integer> flip = map.flipUniqueValues();
        Verify.assertInstanceOf(DoubletonMap.class, flip);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", 1, "Two", 2), flip);
        Assert.assertThrows(IllegalStateException.class, () -> new DoubletonMap<>(1, "One", 2, "One").flipUniqueValues());
    }

    @Override
    @Test
    public void nonUniqueWithKeyValue() {
        Twin<String> twin1 = Tuples.twin("1", "1");
        Twin<String> twin2 = Tuples.twin("2", "2");
        DoubletonMap<Twin<String>, Twin<String>> map = new DoubletonMap<>(twin1, twin1, twin2, twin2);
        Assert.assertSame(map.getKey1(), twin1);
        Assert.assertSame(map.getKey2(), twin2);
        Twin<String> twin3 = Tuples.twin("1", "1");
        map.withKeyValue(twin3, twin3);
        Assert.assertSame(map.get(twin1), twin3);
        Twin<String> twin4 = Tuples.twin("2", "2");
        map.withKeyValue(twin4, twin4);
        Assert.assertSame(map.get(twin2), twin4);
    }

    @Override
    public void withKeyValue() {
        MutableMap<Integer, String> map1 = new DoubletonMap<>(1, "A", 2, "B").withKeyValue(3, "C");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "A", 2, "B", 3, "C"), map1);
        Verify.assertInstanceOf(TripletonMap.class, map1);
        MutableMap<Integer, String> map2 = new DoubletonMap<>(1, "A", 2, "B");
        MutableMap<Integer, String> map2with = map2.withKeyValue(1, "AA");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "AA", 2, "B"), map2with);
        Assert.assertSame(map2, map2with);
    }

    @Override
    public void withAllKeyValueArguments() {
        MutableMap<Integer, String> map1 = new DoubletonMap<>(1, "A", 2, "B").withAllKeyValueArguments(Tuples.pair(1, "AA"), Tuples.pair(3, "C"));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "AA", 2, "B", 3, "C"), map1);
        Verify.assertInstanceOf(TripletonMap.class, map1);
        MutableMap<Integer, String> map2 = new DoubletonMap<>(1, "A", 2, "B");
        MutableMap<Integer, String> map2with = map2.withAllKeyValueArguments(Tuples.pair(1, "AA"));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "AA", 2, "B"), map2with);
        Assert.assertSame(map2, map2with);
    }

    @Override
    public void withoutKey() {
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "A", 2, "B");
        MutableMap<Integer, String> mapWithout1 = map.withoutKey(3);
        Assert.assertSame(map, mapWithout1);
        MutableMap<Integer, String> mapWithout2 = map.withoutKey(1);
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(2, "B"), mapWithout2);
        Verify.assertInstanceOf(SingletonMap.class, mapWithout2);
    }

    @Override
    public void withoutAllKeys() {
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "A", 2, "B");
        MutableMap<Integer, String> mapWithout1 = map.withoutAllKeys(FastList.newListWith(3, 4));
        Assert.assertSame(map, mapWithout1);
        MutableMap<Integer, String> mapWithout2 = map.withoutAllKeys(FastList.newListWith(2, 3));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "A"), mapWithout2);
        Verify.assertInstanceOf(SingletonMap.class, mapWithout2);
    }

    @Override
    @Test
    public void forEachValue() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "1", 2, "2");
        map.forEachValue(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith("1", "2"), collection);
    }

    @Override
    @Test
    public void forEach() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "1", 2, "2");
        map.forEach(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith("1", "2"), collection);
    }

    @Override
    @Test
    public void forEachKey() {
        MutableList<Integer> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "1", 2, "2");
        map.forEachKey(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith(1, 2), collection);
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "1", 2, "2");
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPut(4, new PassThruFunction0<>("4")));
        Assert.assertEquals("1", map.getIfAbsentPut(1, new PassThruFunction0<>("1")));
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "1", 2, "2");
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPutWith(4, String::valueOf, 4));
        Assert.assertEquals("1", map.getIfAbsentPutWith(1, String::valueOf, 1));
    }

    @Override
    @Test
    public void getIfAbsent_function() {
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "1", 2, "2");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsent(4, new PassThruFunction0<>("4")));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void getOrDefault() {
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "1", 2, "2");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("1", map.getOrDefault(1, "4"));
        Assert.assertEquals("4", map.getOrDefault(4, "4"));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void getIfAbsent() {
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "1", 2, "2");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("1", map.getIfAbsentValue(1, "4"));
        Assert.assertEquals("4", map.getIfAbsentValue(4, "4"));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void getIfAbsentWith() {
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "1", 2, "2");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsentWith(4, String::valueOf, 4));
        Assert.assertNull(map.get(4));
    }

    @Override
    @Test
    public void ifPresentApply() {
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "1", 2, "2");
        Assert.assertNull(map.ifPresentApply(4, Functions.getPassThru()));
        Assert.assertEquals("1", map.ifPresentApply(1, Functions.getPassThru()));
        Assert.assertEquals("2", map.ifPresentApply(2, Functions.getPassThru()));
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(new DoubletonMap<>(1, "1", 2, "2").notEmpty());
    }

    @Override
    @Test
    public void forEachWith() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableMap<Integer, Integer> map = new DoubletonMap<>(1, 1, 2, 2);
        map.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 10);
        Assert.assertEquals(FastList.newListWith(11, 12), result);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        MutableList<String> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "One", 2, "Two");
        map.forEachWithIndex((value, index) -> {
            result.add(value);
            result.add(String.valueOf(index));
        });
        Assert.assertEquals(FastList.newListWith("One", "0", "Two", "1"), result);
    }

    @Override
    @Test
    public void entrySet() {
        MutableList<String> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "One", 2, "Two");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        Assert.assertEquals(FastList.newListWith("One", "Two"), result);
    }

    @Override
    @Test
    public void values() {
        MutableList<String> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "One", 2, "Two");
        for (String value : map.values()) {
            result.add(value);
        }
        Assert.assertEquals(FastList.newListWith("One", "Two"), result);
    }

    @Override
    @Test
    public void keySet() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "One", 2, "Two");
        for (Integer key : map.keySet()) {
            result.add(key);
        }
        Assert.assertEquals(FastList.newListWith(1, 2), result);
    }

    @Override
    @Test
    public void testToString() {
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "One", 2, "Two");
        Assert.assertEquals("{1=One, 2=Two}", map.toString());
    }

    @Override
    @Test
    public void asLazyKeys() {
        MutableList<Integer> keys = Maps.fixedSize.of(1, 1, 2, 2).keysView().toSortedList();
        Assert.assertEquals(FastList.newListWith(1, 2), keys);
    }

    @Override
    @Test
    public void asLazyValues() {
        MutableList<Integer> values = Maps.fixedSize.of(1, 1, 2, 2).valuesView().toSortedList();
        Assert.assertEquals(FastList.newListWith(1, 2), values);
    }

    @Override
    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(UnifiedMap.newWithKeysValues("1", "One", "2", "Two"), this.classUnderTest());
    }

    @Override
    @Test
    public void select() {
        MutableMap<String, String> map = this.classUnderTest();
        MutableMap<String, String> empty = map.select((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(EmptyMap.class, empty);
        MutableMap<String, String> full = map.select((ignored1, ignored2) -> true);
        Assert.assertEquals(map, full);
        MutableMap<String, String> one = map.select((argument1, argument2) -> "1".equals(argument1));
        Verify.assertInstanceOf(SingletonMap.class, one);
        Assert.assertEquals(new SingletonMap<>("1", "One"), one);
        MutableMap<String, String> two = map.select((argument1, argument2) -> "2".equals(argument1));
        Verify.assertInstanceOf(SingletonMap.class, two);
        Assert.assertEquals(new SingletonMap<>("2", "Two"), two);
    }

    @Override
    @Test
    public void reject() {
        MutableMap<String, String> map = this.classUnderTest();
        MutableMap<String, String> empty = map.reject((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(EmptyMap.class, empty);
        MutableMap<String, String> full = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(DoubletonMap.class, full);
        Assert.assertEquals(map, full);
        MutableMap<String, String> one = map.reject((argument1, argument2) -> "2".equals(argument1));
        Verify.assertInstanceOf(SingletonMap.class, one);
        Assert.assertEquals(new SingletonMap<>("1", "One"), one);
        MutableMap<String, String> two = map.reject((argument1, argument2) -> "1".equals(argument1));
        Verify.assertInstanceOf(SingletonMap.class, two);
        Assert.assertEquals(new SingletonMap<>("2", "Two"), two);
    }

    @Override
    @Test
    public void detect() {
        MutableMap<String, String> map = this.classUnderTest();
        Pair<String, String> one = map.detect((ignored1, ignored2) -> true);
        Assert.assertEquals(Tuples.pair("1", "One"), one);
        Pair<String, String> two = map.detect((argument1, argument2) -> "2".equals(argument1));
        Assert.assertEquals(Tuples.pair("2", "Two"), two);
        Assert.assertNull(map.detect((ignored1, ignored2) -> false));
    }

    @Override
    protected <K, V> FixedSizeMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new DoubletonMap<>(key1, value1, key2, value2);
    }

    @Override
    protected <K, V> FixedSizeMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new DoubletonMap<>(key1, value1, key2, value2);
    }

    @Override
    @Test
    public void iterator() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new DoubletonMap<>(1, "1", 2, "2");
        for (String eachValue : map) {
            collection.add(eachValue);
        }
        Assert.assertEquals(FastList.newListWith("1", "2"), collection);
    }

    @Test
    public void getOnly() {
        Assert.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOnly());
    }

 
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    @org.openjdk.jmh.annotations.BenchmarkMode(org.openjdk.jmh.annotations.Mode.Throughput)
    @org.openjdk.jmh.annotations.Warmup(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Measurement(iterations = 1, time = 1, timeUnit = java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.OutputTimeUnit(java.util.concurrent.TimeUnit.NANOSECONDS)
    @org.openjdk.jmh.annotations.Fork(value = 1 )
    public static class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsValue, this.description("containsValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKeyValue, this.description("forEachKeyValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flipUniqueValues, this.description("flipUniqueValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nonUniqueWithKeyValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::nonUniqueWithKeyValue, this.description("nonUniqueWithKeyValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachValue, this.description("forEachValue"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachKey, this.description("forEachKey"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPut, this.description("getIfAbsentPut"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentPutWith, this.description("getIfAbsentPutWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent_function() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent_function, this.description("getIfAbsent_function"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOrDefault() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOrDefault, this.description("getOrDefault"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsent() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsent, this.description("getIfAbsent"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getIfAbsentWith, this.description("getIfAbsentWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_ifPresentApply() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::ifPresentApply, this.description("ifPresentApply"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::entrySet, this.description("entrySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::values, this.description("values"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::keySet, this.description("keySet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyKeys() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazyKeys, this.description("asLazyKeys"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazyValues() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::asLazyValues, this.description("asLazyValues"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testEqualsAndHashCode, this.description("testEqualsAndHashCode"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getOnly, this.description("getOnly"));
        }

        private DoubletonMapTest implementation;

        @java.lang.Override
        public void createImplementation() throws java.lang.Throwable {
            this.implementation = new DoubletonMapTest();
        }

        @java.lang.Override
        public DoubletonMapTest implementation() {
            return this.implementation;
        }
    }
}
