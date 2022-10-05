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
 * JUnit test for {@link SingletonMap}.
 */
public class SingletonMapTest extends AbstractMemoryEfficientMutableMapTest {

    @Override
    protected MutableMap<String, String> classUnderTest() {
        return new SingletonMap<>("1", "One");
    }

    @Override
    protected MutableMap<String, Integer> mixedTypeClassUnderTest() {
        return new SingletonMap<>("1", 1);
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
        MutableMap<Integer, String> map = new SingletonMap<>(1, "One");
        map.forEachKeyValue((key, value) -> collection.add(key + value));
        Assert.assertEquals(FastList.newListWith("1One"), collection);
    }

    @Override
    @Test
    public void nonUniqueWithKeyValue() {
        Twin<String> twin1 = Tuples.twin("1", "1");
        Twin<String> twin2 = Tuples.twin("1", "1");
        SingletonMap<Twin<String>, Twin<String>> map = new SingletonMap<>(twin1, twin1);
        map.withKeyValue(twin2, twin2);
        Assert.assertSame(map.getKey1(), twin1);
        Assert.assertSame(map.get(twin1), twin2);
    }

    @Override
    @Test
    public void withKeyValue() {
        MutableMap<Integer, String> map1 = new SingletonMap<>(1, "A").withKeyValue(2, "B");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "A", 2, "B"), map1);
        Verify.assertInstanceOf(DoubletonMap.class, map1);
        MutableMap<Integer, String> map2 = new SingletonMap<>(1, "A");
        MutableMap<Integer, String> map2with = map2.withKeyValue(1, "AA");
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "AA"), map2with);
        Assert.assertSame(map2, map2with);
    }

    @Override
    @Test
    public void withAllKeyValueArguments() {
        MutableMap<Integer, String> map1 = new SingletonMap<>(1, "A").withAllKeyValueArguments(Tuples.pair(1, "AA"), Tuples.pair(2, "B"));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "AA", 2, "B"), map1);
        Verify.assertInstanceOf(DoubletonMap.class, map1);
        MutableMap<Integer, String> map2 = new SingletonMap<>(1, "A");
        MutableMap<Integer, String> map2with = map2.withAllKeyValueArguments(Tuples.pair(1, "AA"));
        Verify.assertMapsEqual(UnifiedMap.newWithKeysValues(1, "AA"), map2with);
        Assert.assertSame(map2, map2with);
    }

    @Override
    @Test
    public void withoutKey() {
        MutableMap<Integer, String> map = new SingletonMap<>(1, "A");
        MutableMap<Integer, String> mapWithout1 = map.withoutKey(2);
        Assert.assertSame(map, mapWithout1);
        MutableMap<Integer, String> mapWithout2 = map.withoutKey(1);
        Verify.assertMapsEqual(UnifiedMap.newMap(), mapWithout2);
        Verify.assertInstanceOf(EmptyMap.class, mapWithout2);
    }

    @Override
    @Test
    public void withoutAllKeys() {
        MutableMap<Integer, String> map = new SingletonMap<>(1, "A");
        MutableMap<Integer, String> mapWithout1 = map.withoutAllKeys(FastList.newListWith(2, 3));
        Assert.assertSame(map, mapWithout1);
        MutableMap<Integer, String> mapWithout2 = map.withoutAllKeys(FastList.newListWith(1, 2));
        Verify.assertMapsEqual(UnifiedMap.newMap(), mapWithout2);
        Verify.assertInstanceOf(EmptyMap.class, mapWithout2);
    }

    @Override
    @Test
    public void forEachValue() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new SingletonMap<>(1, "1");
        map.forEachValue(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith("1"), collection);
    }

    @Override
    @Test
    public void forEach() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new SingletonMap<>(1, "1");
        map.forEach(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith("1"), collection);
    }

    @Override
    @Test
    public void iterator() {
        MutableList<String> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new SingletonMap<>(1, "1");
        for (String eachValue : map) {
            collection.add(eachValue);
        }
        Assert.assertEquals(FastList.newListWith("1"), collection);
    }

    @Override
    @Test
    public void forEachKey() {
        MutableList<Integer> collection = Lists.mutable.of();
        MutableMap<Integer, String> map = new SingletonMap<>(1, "1");
        map.forEachKey(CollectionAddProcedure.on(collection));
        Assert.assertEquals(FastList.newListWith(1), collection);
    }

    @Override
    @Test
    public void getIfAbsentPut() {
        MutableMap<Integer, String> map = new SingletonMap<>(1, "1");
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPut(4, new PassThruFunction0<>("4")));
        Assert.assertEquals("1", map.getIfAbsentPut(1, new PassThruFunction0<>("1")));
    }

    @Override
    @Test
    public void getIfAbsentPutWith() {
        MutableMap<Integer, String> map = new SingletonMap<>(1, "1");
        Assert.assertThrows(UnsupportedOperationException.class, () -> map.getIfAbsentPutWith(4, String::valueOf, 4));
        Assert.assertEquals("1", map.getIfAbsentPutWith(1, String::valueOf, 1));
    }

    @Override
    @Test
    public void getIfAbsent_function() {
        MutableMap<Integer, String> map = new SingletonMap<>(1, "1");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsent(4, new PassThruFunction0<>("4")));
        Assert.assertEquals("1", map.getIfAbsent(1, new PassThruFunction0<>("1")));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1"), map);
    }

    @Override
    @Test
    public void getOrDefault() {
        MutableMap<Integer, String> map = new SingletonMap<>(1, "1");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("1", map.getOrDefault(1, "1"));
        Assert.assertEquals("4", map.getOrDefault(4, "4"));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1"), map);
    }

    @Override
    @Test
    public void getIfAbsent() {
        MutableMap<Integer, String> map = new SingletonMap<>(1, "1");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("1", map.getIfAbsentValue(1, "1"));
        Assert.assertEquals("4", map.getIfAbsentValue(4, "4"));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1"), map);
    }

    @Override
    @Test
    public void getIfAbsentWith() {
        MutableMap<Integer, String> map = new SingletonMap<>(1, "1");
        Assert.assertNull(map.get(4));
        Assert.assertEquals("4", map.getIfAbsentWith(4, String::valueOf, 4));
        Assert.assertEquals("1", map.getIfAbsentWith(1, String::valueOf, 1));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "1"), map);
    }

    @Override
    @Test
    public void ifPresentApply() {
        MutableMap<Integer, String> map = new SingletonMap<>(1, "1");
        Assert.assertNull(map.ifPresentApply(4, Functions.getPassThru()));
        Assert.assertEquals("1", map.ifPresentApply(1, Functions.getPassThru()));
    }

    @Override
    @Test
    public void notEmpty() {
        Assert.assertTrue(new SingletonMap<>(1, "1").notEmpty());
    }

    @Override
    @Test
    public void forEachWith() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableMap<Integer, Integer> map = new SingletonMap<>(1, 1);
        map.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 10);
        Assert.assertEquals(FastList.newListWith(11), result);
    }

    @Override
    @Test
    public void forEachWithIndex() {
        MutableList<String> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new SingletonMap<>(1, "One");
        map.forEachWithIndex((value, index) -> {
            result.add(value);
            result.add(String.valueOf(index));
        });
        Assert.assertEquals(FastList.newListWith("One", "0"), result);
    }

    @Override
    @Test
    public void entrySet() {
        MutableList<String> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new SingletonMap<>(1, "One");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        Assert.assertEquals(FastList.newListWith("One"), result);
    }

    @Override
    @Test
    public void values() {
        MutableList<String> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new SingletonMap<>(1, "One");
        for (String value : map.values()) {
            result.add(value);
        }
        Assert.assertEquals(FastList.newListWith("One"), result);
    }

    @Override
    @Test
    public void keySet() {
        MutableList<Integer> result = Lists.mutable.of();
        MutableMap<Integer, String> map = new SingletonMap<>(1, "One");
        for (Integer key : map.keySet()) {
            result.add(key);
        }
        Assert.assertEquals(FastList.newListWith(1), result);
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("{1=One}", new SingletonMap<>(1, "One").toString());
        Assert.assertEquals("{1=null}", new SingletonMap<Integer, String>(1, null).toString());
        Assert.assertEquals("{null=One}", new SingletonMap<Integer, String>(null, "One").toString());
    }

    @Override
    @Test
    public void testEqualsAndHashCode() {
        Verify.assertEqualsAndHashCode(UnifiedMap.newWithKeysValues("1", "One"), this.classUnderTest());
    }

    @Override
    @Test
    public void asLazyKeys() {
        MutableList<Integer> keys = Maps.fixedSize.of(1, 1).keysView().toSortedList();
        Assert.assertEquals(FastList.newListWith(1), keys);
    }

    @Override
    @Test
    public void asLazyValues() {
        MutableList<Integer> values = Maps.fixedSize.of(1, 1).valuesView().toSortedList();
        Assert.assertEquals(FastList.newListWith(1), values);
    }

    @Override
    @Test
    public void select() {
        MutableMap<String, String> map = this.classUnderTest();
        MutableMap<String, String> empty = map.select((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(EmptyMap.class, empty);
        MutableMap<String, String> full = map.select((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(SingletonMap.class, full);
        Assert.assertEquals(map, full);
    }

    @Override
    @Test
    public void reject() {
        MutableMap<String, String> map = this.classUnderTest();
        MutableMap<String, String> empty = map.reject((ignored1, ignored2) -> true);
        Verify.assertInstanceOf(EmptyMap.class, empty);
        MutableMap<String, String> full = map.reject((ignored1, ignored2) -> false);
        Verify.assertInstanceOf(SingletonMap.class, full);
        Assert.assertEquals(map, full);
    }

    @Override
    @Test
    public void detect() {
        MutableMap<String, String> map = this.classUnderTest();
        Pair<String, String> actual = map.detect((ignored1, ignored2) -> true);
        Assert.assertEquals(Tuples.pair("1", "One"), actual);
        Assert.assertNull(map.detect((ignored1, ignored2) -> false));
    }

    @Test
    public void flipUniqueValues() {
        MutableMap<String, String> flip = new SingletonMap<>("1", "One").flipUniqueValues();
        Verify.assertInstanceOf(SingletonMap.class, flip);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("One", "1"), flip);
    }

    @Test
    public void getOnly() {
        String only = this.classUnderTest().getOnly();
        Assert.assertEquals("One", only);
    }

    @Override
    protected <K, V> FixedSizeMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2) {
        return new SingletonMap<>(key1, value1);
    }

    @Override
    protected <K, V> FixedSizeMap<K, V> newMapWithKeysValues(K key1, V value1, K key2, V value2, K key3, V value3) {
        return new SingletonMap<>(key1, value1);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private SingletonMapTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_put_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.put_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.remove_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_putAll_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.putAll_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeKey_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeKey_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAllKeys_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllKeys_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectKeysAndValues_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectKeysAndValues_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_updateValueWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.updateValueWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testPostSerializedEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testPostSerializedEqualsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
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
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfy);
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
        public void benchmark_flip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flip);
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
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
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
        public void benchmark_flatten_value() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatten_value);
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
        public void benchmark_tap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.tap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_nonUniqueWithKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.nonUniqueWithKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withKeyValue() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withKeyValue);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAllKeyValueArguments() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAllKeyValueArguments);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutKey);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAllKeys() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAllKeys);
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
        public void benchmark_getIfAbsentPut() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPut);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getIfAbsentPutWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getIfAbsentPutWith);
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
        public void benchmark_entrySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.entrySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_values() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.values);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_keySet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.keySet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testEqualsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testEqualsAndHashCode);
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
        public void benchmark_flipUniqueValues() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flipUniqueValues);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> payload) throws java.lang.Throwable {
            this.instance = new SingletonMapTest();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> put_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> putAll_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> clear_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> removeKey_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> removeAllKeys_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> removeIf_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> collectKeysAndValues_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> updateValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> updateValueWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> testPostSerializedEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> collectValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> flip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> collect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> containsAllArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> detect_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> detectIfNone_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> flatten_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> reject_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> rejectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> select_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> selectWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> partition_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> partitionWith_value;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> containsValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> forEachKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> nonUniqueWithKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> withKeyValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> withAllKeyValueArguments;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> withoutKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> withoutAllKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> forEachValue;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> forEachKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> getIfAbsentPut;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> getIfAbsentPutWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> getIfAbsent_function;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> getOrDefault;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> getIfAbsent;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> getIfAbsentWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> ifPresentApply;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> entrySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> values;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> keySet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> testEqualsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> asLazyKeys;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> asLazyValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> flipUniqueValues;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<SingletonMapTest> getOnly;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.put_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonMapTest::put_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonMapTest::remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.putAll_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonMapTest::putAll_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.clear_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonMapTest::clear_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeKey_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonMapTest::removeKey_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeAllKeys_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonMapTest::removeAllKeys_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.removeIf_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonMapTest::removeIf_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.collectKeysAndValues_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonMapTest::collectKeysAndValues_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValue = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonMapTest::updateValue, java.lang.UnsupportedOperationException.class);
            this.payloads.updateValueWith = new se.chalmers.ju2jmh.api.ExceptionTest<>(SingletonMapTest::updateValueWith, java.lang.UnsupportedOperationException.class);
            this.payloads.asUnmodifiable = SingletonMapTest::asUnmodifiable;
            this.payloads.asSynchronized = SingletonMapTest::asSynchronized;
            this.payloads.newEmpty = SingletonMapTest::newEmpty;
            this.payloads.toImmutable = SingletonMapTest::toImmutable;
            this.payloads.testPostSerializedEqualsAndHashCode = SingletonMapTest::testPostSerializedEqualsAndHashCode;
            this.payloads.testClone = SingletonMapTest::testClone;
            this.payloads.collectValues = SingletonMapTest::collectValues;
            this.payloads.collect = SingletonMapTest::collect;
            this.payloads.allSatisfy = SingletonMapTest::allSatisfy;
            this.payloads.noneSatisfy = SingletonMapTest::noneSatisfy;
            this.payloads.anySatisfy = SingletonMapTest::anySatisfy;
            this.payloads.appendString = SingletonMapTest::appendString;
            this.payloads.toBag = SingletonMapTest::toBag;
            this.payloads.flip = SingletonMapTest::flip;
            this.payloads.asLazy = SingletonMapTest::asLazy;
            this.payloads.toList = SingletonMapTest::toList;
            this.payloads.toMap = SingletonMapTest::toMap;
            this.payloads.toSet = SingletonMapTest::toSet;
            this.payloads.toSortedList = SingletonMapTest::toSortedList;
            this.payloads.toSortedListBy = SingletonMapTest::toSortedListBy;
            this.payloads.chunk = SingletonMapTest::chunk;
            this.payloads.collect_value = SingletonMapTest::collect_value;
            this.payloads.collectIf = SingletonMapTest::collectIf;
            this.payloads.collectWith = SingletonMapTest::collectWith;
            this.payloads.contains = SingletonMapTest::contains;
            this.payloads.getFirst = SingletonMapTest::getFirst;
            this.payloads.getLast = SingletonMapTest::getLast;
            this.payloads.containsAllIterable = SingletonMapTest::containsAllIterable;
            this.payloads.containsAllArguments = SingletonMapTest::containsAllArguments;
            this.payloads.count = SingletonMapTest::count;
            this.payloads.detect_value = SingletonMapTest::detect_value;
            this.payloads.detectIfNone_value = SingletonMapTest::detectIfNone_value;
            this.payloads.flatten_value = SingletonMapTest::flatten_value;
            this.payloads.groupBy = SingletonMapTest::groupBy;
            this.payloads.groupByEach = SingletonMapTest::groupByEach;
            this.payloads.injectInto = SingletonMapTest::injectInto;
            this.payloads.makeString = SingletonMapTest::makeString;
            this.payloads.min = SingletonMapTest::min;
            this.payloads.max = SingletonMapTest::max;
            this.payloads.minBy = SingletonMapTest::minBy;
            this.payloads.maxBy = SingletonMapTest::maxBy;
            this.payloads.reject_value = SingletonMapTest::reject_value;
            this.payloads.rejectWith_value = SingletonMapTest::rejectWith_value;
            this.payloads.select_value = SingletonMapTest::select_value;
            this.payloads.selectWith_value = SingletonMapTest::selectWith_value;
            this.payloads.partition_value = SingletonMapTest::partition_value;
            this.payloads.partitionWith_value = SingletonMapTest::partitionWith_value;
            this.payloads.toArray = SingletonMapTest::toArray;
            this.payloads.zip = SingletonMapTest::zip;
            this.payloads.zipWithIndex = SingletonMapTest::zipWithIndex;
            this.payloads.tap = SingletonMapTest::tap;
            this.payloads.containsValue = SingletonMapTest::containsValue;
            this.payloads.forEachKeyValue = SingletonMapTest::forEachKeyValue;
            this.payloads.nonUniqueWithKeyValue = SingletonMapTest::nonUniqueWithKeyValue;
            this.payloads.withKeyValue = SingletonMapTest::withKeyValue;
            this.payloads.withAllKeyValueArguments = SingletonMapTest::withAllKeyValueArguments;
            this.payloads.withoutKey = SingletonMapTest::withoutKey;
            this.payloads.withoutAllKeys = SingletonMapTest::withoutAllKeys;
            this.payloads.forEachValue = SingletonMapTest::forEachValue;
            this.payloads.forEach = SingletonMapTest::forEach;
            this.payloads.iterator = SingletonMapTest::iterator;
            this.payloads.forEachKey = SingletonMapTest::forEachKey;
            this.payloads.getIfAbsentPut = SingletonMapTest::getIfAbsentPut;
            this.payloads.getIfAbsentPutWith = SingletonMapTest::getIfAbsentPutWith;
            this.payloads.getIfAbsent_function = SingletonMapTest::getIfAbsent_function;
            this.payloads.getOrDefault = SingletonMapTest::getOrDefault;
            this.payloads.getIfAbsent = SingletonMapTest::getIfAbsent;
            this.payloads.getIfAbsentWith = SingletonMapTest::getIfAbsentWith;
            this.payloads.ifPresentApply = SingletonMapTest::ifPresentApply;
            this.payloads.notEmpty = SingletonMapTest::notEmpty;
            this.payloads.forEachWith = SingletonMapTest::forEachWith;
            this.payloads.forEachWithIndex = SingletonMapTest::forEachWithIndex;
            this.payloads.entrySet = SingletonMapTest::entrySet;
            this.payloads.values = SingletonMapTest::values;
            this.payloads.keySet = SingletonMapTest::keySet;
            this.payloads.testToString = SingletonMapTest::testToString;
            this.payloads.testEqualsAndHashCode = SingletonMapTest::testEqualsAndHashCode;
            this.payloads.asLazyKeys = SingletonMapTest::asLazyKeys;
            this.payloads.asLazyValues = SingletonMapTest::asLazyValues;
            this.payloads.select = SingletonMapTest::select;
            this.payloads.reject = SingletonMapTest::reject;
            this.payloads.detect = SingletonMapTest::detect;
            this.payloads.flipUniqueValues = SingletonMapTest::flipUniqueValues;
            this.payloads.getOnly = SingletonMapTest::getOnly;
        }
    }
}
