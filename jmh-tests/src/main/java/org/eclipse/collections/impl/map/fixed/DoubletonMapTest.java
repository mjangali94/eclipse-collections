/*
 * Copyright (c) 2021 Goldman Sachs.
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

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private DoubletonMapTest instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysAndValues_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPostSerializedEqualsAndHashCode);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
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
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
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
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
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
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
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
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
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
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValueArguments);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nonUniqueWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nonUniqueWithKeyValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachValue);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
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
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
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
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsAndHashCode);
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
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new DoubletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> put_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> putAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> clear_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> removeKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> removeAllKeys_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> removeIf_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> collectKeysAndValues_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> testPostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> nonUniqueWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> asLazyKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> asLazyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<DoubletonMapTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.put_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonMapTest::put_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonMapTest::remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.putAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonMapTest::putAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.clear_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonMapTest::clear_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonMapTest::removeKey_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllKeys_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonMapTest::removeAllKeys_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonMapTest::removeIf_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.collectKeysAndValues_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonMapTest::collectKeysAndValues_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValueWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(DoubletonMapTest::updateValueWith, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = DoubletonMapTest::asUnmodifiable;
            this.payloads.asSynchronized = DoubletonMapTest::asSynchronized;
            this.payloads.newEmpty = DoubletonMapTest::newEmpty;
            this.payloads.toImmutable = DoubletonMapTest::toImmutable;
            this.payloads.testPostSerializedEqualsAndHashCode = DoubletonMapTest::testPostSerializedEqualsAndHashCode;
            this.payloads.testClone = DoubletonMapTest::testClone;
            this.payloads.collectValues = DoubletonMapTest::collectValues;
            this.payloads.collect = DoubletonMapTest::collect;
            this.payloads.allSatisfy = DoubletonMapTest::allSatisfy;
            this.payloads.noneSatisfy = DoubletonMapTest::noneSatisfy;
            this.payloads.anySatisfy = DoubletonMapTest::anySatisfy;
            this.payloads.appendString = DoubletonMapTest::appendString;
            this.payloads.toBag = DoubletonMapTest::toBag;
            this.payloads.flip = DoubletonMapTest::flip;
            this.payloads.asLazy = DoubletonMapTest::asLazy;
            this.payloads.toList = DoubletonMapTest::toList;
            this.payloads.toMap = DoubletonMapTest::toMap;
            this.payloads.toSet = DoubletonMapTest::toSet;
            this.payloads.toSortedList = DoubletonMapTest::toSortedList;
            this.payloads.toSortedListBy = DoubletonMapTest::toSortedListBy;
            this.payloads.chunk = DoubletonMapTest::chunk;
            this.payloads.collect_value = DoubletonMapTest::collect_value;
            this.payloads.collectIf = DoubletonMapTest::collectIf;
            this.payloads.collectWith = DoubletonMapTest::collectWith;
            this.payloads.contains = DoubletonMapTest::contains;
            this.payloads.getFirst = DoubletonMapTest::getFirst;
            this.payloads.getLast = DoubletonMapTest::getLast;
            this.payloads.containsAllIterable = DoubletonMapTest::containsAllIterable;
            this.payloads.containsAllArguments = DoubletonMapTest::containsAllArguments;
            this.payloads.count = DoubletonMapTest::count;
            this.payloads.detect_value = DoubletonMapTest::detect_value;
            this.payloads.detectIfNone_value = DoubletonMapTest::detectIfNone_value;
            this.payloads.flatten_value = DoubletonMapTest::flatten_value;
            this.payloads.groupBy = DoubletonMapTest::groupBy;
            this.payloads.groupByEach = DoubletonMapTest::groupByEach;
            this.payloads.injectInto = DoubletonMapTest::injectInto;
            this.payloads.makeString = DoubletonMapTest::makeString;
            this.payloads.min = DoubletonMapTest::min;
            this.payloads.max = DoubletonMapTest::max;
            this.payloads.minBy = DoubletonMapTest::minBy;
            this.payloads.maxBy = DoubletonMapTest::maxBy;
            this.payloads.reject_value = DoubletonMapTest::reject_value;
            this.payloads.rejectWith_value = DoubletonMapTest::rejectWith_value;
            this.payloads.select_value = DoubletonMapTest::select_value;
            this.payloads.selectWith_value = DoubletonMapTest::selectWith_value;
            this.payloads.partition_value = DoubletonMapTest::partition_value;
            this.payloads.partitionWith_value = DoubletonMapTest::partitionWith_value;
            this.payloads.toArray = DoubletonMapTest::toArray;
            this.payloads.zip = DoubletonMapTest::zip;
            this.payloads.zipWithIndex = DoubletonMapTest::zipWithIndex;
            this.payloads.withKeyValue = DoubletonMapTest::withKeyValue;
            this.payloads.withAllKeyValueArguments = DoubletonMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = DoubletonMapTest::withoutKey;
            this.payloads.withoutAllKeys = DoubletonMapTest::withoutAllKeys;
            this.payloads.tap = DoubletonMapTest::tap;
            this.payloads.containsValue = DoubletonMapTest::containsValue;
            this.payloads.forEachKeyValue = DoubletonMapTest::forEachKeyValue;
            this.payloads.flipUniqueValues = DoubletonMapTest::flipUniqueValues;
            this.payloads.nonUniqueWithKeyValue = DoubletonMapTest::nonUniqueWithKeyValue;
            this.payloads.forEachValue = DoubletonMapTest::forEachValue;
            this.payloads.forEach = DoubletonMapTest::forEach;
            this.payloads.forEachKey = DoubletonMapTest::forEachKey;
            this.payloads.getIfAbsentPut = DoubletonMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutWith = DoubletonMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsent_function = DoubletonMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = DoubletonMapTest::getOrDefault;
            this.payloads.getIfAbsent = DoubletonMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = DoubletonMapTest::getIfAbsentWith;
            this.payloads.ifPresentApply = DoubletonMapTest::ifPresentApply;
            this.payloads.notEmpty = DoubletonMapTest::notEmpty;
            this.payloads.forEachWith = DoubletonMapTest::forEachWith;
            this.payloads.forEachWithIndex = DoubletonMapTest::forEachWithIndex;
            this.payloads.entrySet = DoubletonMapTest::entrySet;
            this.payloads.values = DoubletonMapTest::values;
            this.payloads.keySet = DoubletonMapTest::keySet;
            this.payloads.testToString = DoubletonMapTest::testToString;
            this.payloads.asLazyKeys = DoubletonMapTest::asLazyKeys;
            this.payloads.asLazyValues = DoubletonMapTest::asLazyValues;
            this.payloads.testEqualsAndHashCode = DoubletonMapTest::testEqualsAndHashCode;
            this.payloads.select = DoubletonMapTest::select;
            this.payloads.reject = DoubletonMapTest::reject;
            this.payloads.detect = DoubletonMapTest::detect;
            this.payloads.iterator = DoubletonMapTest::iterator;
            this.payloads.getOnly = DoubletonMapTest::getOnly;
        }
    }
*/
}
